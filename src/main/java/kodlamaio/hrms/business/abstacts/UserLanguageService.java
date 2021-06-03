package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserLanguage;

public interface UserLanguageService {
	Result add(UserLanguage userLanguage);
	Result update(UserLanguage userLanguage);
	Result delete(UserLanguage userLanguage);
	
	DataResult<List<UserLanguage>> getAll();
}
