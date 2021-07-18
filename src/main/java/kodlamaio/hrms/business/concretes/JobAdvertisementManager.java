package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.Dto.JobAdvertisementDetail;
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
	public DataResult<List<JobAdvertisementList>> getAllByIsActiveTrueAndIsApprovedTrue() {
		return new SuccessDataResult<List<JobAdvertisementList>>(this.jobAdvertisementDao.getByIsActiveTrueAndIsApprovedTrueDetail());
	}

	@Override
	public DataResult<List<JobAdvertisementList>> getAllActiveAndIsApprovedWithDeadline(Date deadline) {
		return new SuccessDataResult<List<JobAdvertisementList>>(this.jobAdvertisementDao.getAllActiveAndIsApprovedWithDeadline(deadline));
	}

	@Override
	public DataResult<List<JobAdvertisementList>> getAllActiveWithCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementList>>(this.jobAdvertisementDao.getAllActiveWithCompanyName(companyName));
	}

	@Override
	public DataResult<List<JobAdvertisementDetail>> getByIsActiveTrueAndIsApprovedTrueDetail() {
		return new SuccessDataResult<List<JobAdvertisementDetail>>(this.jobAdvertisementDao.getByIsActiveTrueAndIsApprovedTrue());
	}

	@Override
	public DataResult<List<JobAdvertisementDetail>> getAllDetailByUserId(int userId) {
		return new SuccessDataResult<List<JobAdvertisementDetail>>(this.jobAdvertisementDao.getAllDetailByUserId(userId));
	}

	@Override
	public DataResult<JobAdvertisementDetail> getDetailById(int id) {
		return new SuccessDataResult<JobAdvertisementDetail>(this.jobAdvertisementDao.getDetailById(id));
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertisementDetail>> getAllDetail() {
		return new SuccessDataResult<List<JobAdvertisementDetail>>(this.jobAdvertisementDao.getAllDetail());
	}

	@Override
	public DataResult<List<JobAdvertisementDetail>> GetAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisementDetail>>(this.jobAdvertisementDao.getByIsActiveTrueAndIsApprovedTrue(pageable).getContent());
	}

	@Override
	public DataResult<Integer> getTotalPages(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<Integer>(this.jobAdvertisementDao.getByIsActiveTrueAndIsApprovedTrue(pageable).getTotalPages());
	}


}
