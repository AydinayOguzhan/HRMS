package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.Dto.JobAdvertisementList;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		long millis = System.currentTimeMillis();
		Date dateNow = new Date(millis);
		jobAdvertisement.setPublishDate(dateNow);
		
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		long millis = System.currentTimeMillis();
		Date dateNow = new Date(millis);
		jobAdvertisement.setPublishDate(dateNow);
		
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public Result closeAdvertisement(int advertisementId) {
		var advertisement = this.jobAdvertisementDao.getById(advertisementId);
		advertisement.setActive(false);
		this.update(advertisement);
		return new SuccessResult("İlan kapatıldı");
	}

	@Override
	public DataResult<List<JobAdvertisementList>> getAllActive() {
		return new SuccessDataResult<List<JobAdvertisementList>>(this.jobAdvertisementDao.getAllActive());
	}

	@Override
	public DataResult<List<JobAdvertisementList>> getAllActiveWithDeadline(Date deadline) {
		return new SuccessDataResult<List<JobAdvertisementList>>(this.jobAdvertisementDao.getAllActiveWithDeadline(deadline));
	}

	@Override
	public DataResult<List<JobAdvertisementList>> getAllActiveWithCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementList>>(this.jobAdvertisementDao.getAllActiveWithCompanyName(companyName));
	}

}
