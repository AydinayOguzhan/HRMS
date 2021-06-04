package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserCoverLetter;

public interface UserCoverLetterService {
	Result add(UserCoverLetter userCoverLetter);
	Result update(UserCoverLetter userCoverLetter);
	Result delete(UserCoverLetter userCoverLetter);
	
	DataResult<List<UserCoverLetter>> getAll();
	DataResult<UserCoverLetter> getByUserId(int userId);
}
