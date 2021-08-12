package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUpdateInformation;

public interface EmployerUpdateInformationService {
	Result add(EmployerUpdateInformation employer);
	Result update(EmployerUpdateInformation employer);
	
	DataResult<List<EmployerUpdateInformation>> getAll();
	DataResult<EmployerUpdateInformation> getByUserId(int userId);
	
}
