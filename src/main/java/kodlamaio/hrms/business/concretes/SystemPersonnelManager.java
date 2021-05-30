package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.business.abstacts.SystemPersonnelService;
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
	
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, EmployerService employerService) {
		this.systemPersonnelDao = systemPersonnelDao;
		this.employerService = employerService;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(systemPersonnelDao.findAll(), "Getirme işlemi başarılı");
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result verification(int userId, boolean verified) {
		var result = employerService.verification(userId, verified);
		if (!result.isSuccess()) {
			return new ErrorResult("Hesap onaylama işlemi başarısız");
		}
		return new SuccessResult("Hesap onaylama işlemi başarılı");
	}

}
