package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	DataResult<List<SystemPersonnel>> getAll();
	Result add(SystemPersonnel systemPersonnel);
	
	Result verification(int userId, boolean verified);
}
