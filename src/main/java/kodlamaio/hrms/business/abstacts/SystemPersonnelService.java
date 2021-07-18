package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	DataResult<List<SystemPersonnel>> getAll();
	Result add(SystemPersonnel systemPersonnel);
	Result update(SystemPersonnel systemPersonnel);
	Result delete(SystemPersonnel systemPersonnel);
	DataResult<SystemPersonnel> getByUserId(int userId);
	
	
	Result verification(int userId, boolean verified);
	Result verifyJobAdvertisements(int id, boolean verified);
}
