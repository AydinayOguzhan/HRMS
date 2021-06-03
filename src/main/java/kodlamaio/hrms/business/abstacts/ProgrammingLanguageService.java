package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	Result add(ProgrammingLanguage programmingLanguage);
	Result update(ProgrammingLanguage programmingLanguage);
	Result delete(ProgrammingLanguage programmingLanguage);
	
	DataResult<List<ProgrammingLanguage>> getAll();
}
