package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.business.abstacts.EmployerUpdateInformationService;
import kodlamaio.hrms.business.abstacts.VerificationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdateInformation;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationCodeService verificationCodeService;
	private EmployerUpdateInformationService employerUpdateInformationService;
	
	public EmployerManager(EmployerDao employerDao, VerificationCodeService verificationCodeService, 
			EmployerUpdateInformationService employerUpdateInformationService) {
		this.employerDao = employerDao;
		this.verificationCodeService = verificationCodeService;
		this.employerUpdateInformationService = employerUpdateInformationService;
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
		var oldData = employerDao.getByUserId(employer.getUserId());
		oldData.setUpdated(true);
		
		var newData = createNewEmployerUpdateInformationData(employer);
		var controlData = employerUpdateInformationService.getByUserId(employer.getUserId());
		if(controlData.getData() == null) {
			employerUpdateInformationService.add(newData);
		}else {
			employerUpdateInformationService.update(newData);
		}
		
		this.employerDao.save(oldData);
		return new SuccessResult(Messages.updateSuccessful + ". " + Messages.waitForConfirmation);
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
	
	@Override
	public Result approveUpdatedData(int userId) {
		var oldData = employerUpdateInformationService.getByUserId(userId);
		oldData.getData().setUpdated(false);
		var employer = createEmployerData(oldData.getData());
		
		employerDao.save(employer);
		
		employerUpdateInformationService.update(oldData.getData());
		return new SuccessResult(Messages.confirmationSuccessful);
	}
	
	private EmployerUpdateInformation createNewEmployerUpdateInformationData(Employer employer) {
		EmployerUpdateInformation updateInformation = new EmployerUpdateInformation();
		updateInformation.setApproved(employer.isApproved());
		updateInformation.setCompanyName(employer.getCompanyName());
		updateInformation.setMailVerified(employer.isMailVerified());
		updateInformation.setPhoneNumber(employer.getPhoneNumber());
		updateInformation.setUpdated(true);
		updateInformation.setUserId(employer.getUserId());
		updateInformation.setWebsite(employer.getWebsite());
		
		return updateInformation;
	}
	
	
	private Employer createEmployerData(EmployerUpdateInformation data) {
		Employer employer = new Employer();
		employer.setApproved(data.isApproved());
		employer.setCompanyName(data.getCompanyName());
		employer.setMailVerified(data.isMailVerified());
		employer.setPhoneNumber(data.getPhoneNumber());
		employer.setUpdated(data.isUpdated());
		employer.setUserId(data.getUserId());
		employer.setWebsite(data.getWebsite());
		
		return employer;
	}


}
