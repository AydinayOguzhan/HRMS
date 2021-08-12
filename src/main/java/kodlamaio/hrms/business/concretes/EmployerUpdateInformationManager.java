package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.EmployerUpdateInformationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateInformationDao;
import kodlamaio.hrms.entities.concretes.EmployerUpdateInformation;

@Service
public class EmployerUpdateInformationManager implements EmployerUpdateInformationService{

	private EmployerUpdateInformationDao employerUpdateInformationDao;
	
	@Autowired
	public EmployerUpdateInformationManager(EmployerUpdateInformationDao employerUpdateInformationDao) {
		this.employerUpdateInformationDao = employerUpdateInformationDao;
	}

	@Override
	public Result add(EmployerUpdateInformation employer) {
		employerUpdateInformationDao.save(employer);
		return new SuccessResult(Messages.successful);
	}

	@Override
	public Result update(EmployerUpdateInformation employer) {
		employerUpdateInformationDao.save(employer);
		return new SuccessResult(Messages.successful);
	}

	@Override
	public DataResult<List<EmployerUpdateInformation>> getAll() {
		return new SuccessDataResult<List<EmployerUpdateInformation>>(employerUpdateInformationDao.findAll());
	}

	@Override
	public DataResult<EmployerUpdateInformation> getByUserId(int userId) {
		return new SuccessDataResult<EmployerUpdateInformation>(employerUpdateInformationDao.getByUserId(userId));
	}


}
