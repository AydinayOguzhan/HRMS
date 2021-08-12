package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	Result update(Employer employer);
	Result updatePermanently(Employer employer);
	
	DataResult<Employer> getByUserId(int userId);
	Result verification(int userId, boolean verified);
	Result emailVerification(int userId, String code);
	
	Result approveUpdatedData(int userId);
}
