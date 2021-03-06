package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.codec.binary.BinaryCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.business.abstacts.ImageService;
import kodlamaio.hrms.business.abstacts.UserImageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.UserImage;

@Service
public class CloudinaryImageAdapter implements ImageService {

	private UserImageService userImageService;

	@Autowired
	public CloudinaryImageAdapter(UserImageService userImageService) {
		this.userImageService = userImageService;
	}

	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "aydinayoguzhan", "api_key",
			"848997974779594", "api_secret", "vkQeKkKpthX49KB7rIGrsKnaVP0"));

	@Override
	public DataResult<Map> uploadImage(MultipartFile file, int userId) throws IOException {
		var checkIfImageExists = userImageService.getByUserId(userId);
		if (checkIfImageExists.getData().getPublicId() != Messages.defaultImage) {
			return new ErrorDataResult<Map>(Messages.deletePreviousImageTryAgain);
		}

		var result = cloudinary.uploader().upload(file.getBytes(),
				ObjectUtils.asMap("resource_type", "auto", "folder", "profile_photos"));
		var publicId = result.get("public_id");
		var imageLink = result.get("url");

		UserImage userImage = new UserImage(userId, publicId.toString(), imageLink.toString());
		userImageService.add(userImage);

		return new SuccessDataResult<Map>(result, Messages.successful);
	}

	@Override
	public DataResult<Map> deleteImage(int userId) throws Exception {
		var user = userImageService.getByUserId(userId);
		if (user.getData() == null) {
			return new ErrorDataResult<Map>(Messages.thereIsNoImageOfUser);
		}

		var result = cloudinary.uploader().destroy(user.getData().getPublicId(), ObjectUtils.emptyMap());

		UserImage userImage = new UserImage(userId, user.getData().getPublicId(), user.getData().getImageLink());

		userImageService.delete(userImage);

		return new SuccessDataResult<Map>(result, Messages.deleteSuccessful);
	}

	@Override
	public DataResult<String> getUserImage(int userId) {
		var result = userImageService.getByUserId(userId);
		return new SuccessDataResult<String>(result.getData().getImageLink(), Messages.successful);
	}

}
