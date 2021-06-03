package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserSchool;

public interface UserSchoolService {
	DataResult<List<UserSchool>> getAll();
	Result add(UserSchool userSchool);
	Result update(UserSchool userSchool);
	Result delete(UserSchool userSchool);
	
	DataResult<List<UserSchool>> getByUserIdOrderByGraduateDateDesc(int userId);
}
