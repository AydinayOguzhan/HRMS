package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.JobSeekerService;
import kodlamaio.hrms.business.abstacts.VerificationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private VerificationCodeService verificationCodeService;
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationCodeService verificationCodeService) {
		this.jobSeekerDao = jobSeekerDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public DataResult<JobSeeker> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByNationalityId(nationalityId));
	}

	@Override
	public Result emailVerification(int userId, String code) {
		var result = verificationCodeService.checkVerificationCode(userId, code);
		if (!result.isSuccess()) {
			return new ErrorResult(Messages.confirmationUnsuccessful);
		}
		var jobSeeker = getByUserId(userId);
		jobSeeker.getData().setVerified(true);
		this.update(jobSeeker.getData());
		return new SuccessResult(Messages.confirmationSuccessful);
	}

	@Override
	public DataResult<JobSeeker> getByUserId(int userId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByUserId(userId));
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.updateSuccessful);
	}

}
