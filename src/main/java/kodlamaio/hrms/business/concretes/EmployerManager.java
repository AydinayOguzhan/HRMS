package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.business.abstacts.VerificationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationCodeService verificationCodeService;
	
	public EmployerManager(EmployerDao employerDao, VerificationCodeService verificationCodeService) {
		this.employerDao = employerDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(Messages.addingSuccessful);
	}
	
	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public DataResult<Employer> getByUserId(int userId) {
		return new SuccessDataResult<Employer>(this.employerDao.getByUserId(userId));
	}

	@Override
	public Result verification(int userId, boolean verified) {
		var employer = getByUserId(userId);
		employer.getData().setApproved(verified);
		var result = this.update(employer.getData());
		if (!result.isSuccess()) {
			return new ErrorResult(Messages.confirmationUnsuccessful);
		}
		return new SuccessResult(Messages.confirmationSuccessful);
	}

	@Override
	public Result emailVerification(int userId, String code) {
		var result = verificationCodeService.checkVerificationCode(userId, code);
		if (!result.isSuccess()) {
			return new ErrorResult(Messages.confirmationUnsuccessful);
		}
		var employer = getByUserId(userId);
		employer.getData().setMailVerified(true);
		this.update(employer.getData());
		return new SuccessResult(Messages.confirmationSuccessful);
	}


}
