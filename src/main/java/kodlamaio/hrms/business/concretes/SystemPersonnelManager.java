package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.business.abstacts.JobAdvertisementService;
import kodlamaio.hrms.business.abstacts.SystemPersonnelService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService{

	private SystemPersonnelDao systemPersonnelDao;
	private EmployerService employerService;
	private JobAdvertisementService jobAdvertisementService;
	
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, EmployerService employerService,
			JobAdvertisementService jobAdvertisementService) {
		this.systemPersonnelDao = systemPersonnelDao;
		this.employerService = employerService;
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(systemPersonnelDao.findAll());
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result verification(int userId, boolean verified) {
		var result = employerService.verification(userId, verified);
		if (!result.isSuccess()) {
			return new ErrorResult(Messages.confirmationSuccessful);
		}
		return new SuccessResult(Messages.confirmationUnsuccessful);
	}

	@Override
	public Result verifyJobAdvertisements(int id, boolean verified) {
		var result = jobAdvertisementService.getById(id);
		result.getData().setApproved(verified);
		var update = jobAdvertisementService.update(result.getData());
		if (!update.isSuccess()) {
			return new ErrorResult(Messages.confirmationUnsuccessful);
		}
		return new SuccessResult(Messages.confirmationSuccessful);
	}

	@Override
	public Result update(SystemPersonnel systemPersonnel) {
		systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(SystemPersonnel systemPersonnel) {
		systemPersonnelDao.delete(systemPersonnel);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<SystemPersonnel> getByUserId(int userId) {
		return new SuccessDataResult<SystemPersonnel>(this.systemPersonnelDao.getByUserId(userId));
	}

}
