package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserImageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserImageDao;
import kodlamaio.hrms.entities.concretes.UserImage;

@Service
public class UserImageManager implements UserImageService{

	private UserImageDao userImageDao;
	
	@Autowired
	public UserImageManager(UserImageDao userImageDao) {
		this.userImageDao = userImageDao;
	}

	@Override
	public Result add(UserImage userImage) {
		this.userImageDao.save(userImage);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(UserImage userImage) {
		this.userImageDao.save(userImage);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(UserImage userImage) {
		this.userImageDao.delete(userImage);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<UserImage>> getAll() {
		return new SuccessDataResult<List<UserImage>>(this.userImageDao.findAll());
	}

	@Override
	public DataResult<UserImage> getByUserId(int userId) {
		var result = this.userImageDao.getByUserId(userId);
		if (result == null) {
			var newResult = new UserImage();
			newResult.setImageLink(Messages.defaultImageLink);
			newResult.setPublicId(Messages.defaultImage);
			newResult.setUserId(userId);	
			return new SuccessDataResult<UserImage>(newResult);
		}
		return new SuccessDataResult<UserImage>(result);
	}

}
