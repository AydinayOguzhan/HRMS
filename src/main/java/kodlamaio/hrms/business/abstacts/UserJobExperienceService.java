package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserJobExperience;

public interface UserJobExperienceService {
	DataResult<List<UserJobExperience>> getAll();
	Result add(UserJobExperience userJobExperience);
	Result update(UserJobExperience userJobExperience);
	Result delete(UserJobExperience userJobExperience);
	
	DataResult<List<UserJobExperience>> getByUserIdOrderByQuitDateDesc(int userId);
}
