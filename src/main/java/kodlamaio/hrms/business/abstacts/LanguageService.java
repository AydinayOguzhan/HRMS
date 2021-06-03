package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);
	Result update(Language language);
	Result delete(Language language);
	
	DataResult<List<Language>> getAll();
}