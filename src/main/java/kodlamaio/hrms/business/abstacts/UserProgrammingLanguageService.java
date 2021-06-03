package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserProgrammingLanguage;

public interface UserProgrammingLanguageService {
	Result add(UserProgrammingLanguage userProgrammingLanguage);
	Result update(UserProgrammingLanguage userProgrammingLanguage);
	Result delete(UserProgrammingLanguage userProgrammingLanguage);
	
	DataResult<List<UserProgrammingLanguage>> getAll();
}
