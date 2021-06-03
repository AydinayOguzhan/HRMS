package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserImage;

public interface UserImageService {
	Result add(UserImage userImage);
	Result update(UserImage userImage);
	Result delete(UserImage userImage);
	
	DataResult<List<UserImage>> getAll();
	DataResult<UserImage> getByUserId(int userId);
}
