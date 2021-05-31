package kodlamaio.hrms.business.abstacts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Dto.JobAdvertisementList;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	Result closeAdvertisement(int advertisementId);
	
	DataResult<List<JobAdvertisementList>> getAllActive();
	DataResult<List<JobAdvertisementList>> getAllActiveWithDeadline(Date deadline);
	DataResult<List<JobAdvertisementList>> getAllActiveWithCompanyName(String companyName);
}
