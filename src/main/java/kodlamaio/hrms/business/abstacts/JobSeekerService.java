package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getByNationalityId(String nationalityId);
	DataResult<JobSeeker> getByUserId(int userId);
	Result add(JobSeeker jobSeeker);
	Result update(JobSeeker jobSeeker);
	
	Result emailVerification(int userId, String code);
}
