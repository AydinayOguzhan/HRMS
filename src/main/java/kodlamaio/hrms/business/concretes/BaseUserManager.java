package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.BaseUserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.BaseUserDao;
import kodlamaio.hrms.entities.concretes.BaseUser;

@Service
public class BaseUserManager implements BaseUserService{

	private BaseUserDao baseUserDao;
	
	public BaseUserManager(BaseUserDao baseUserDao) {
		this.baseUserDao = baseUserDao;
	}

	@Override
	public DataResult<List<BaseUser>> getAll() {
		return new SuccessDataResult<List<BaseUser>>(baseUserDao.findAll());
	}

	@Override
	public Result add(BaseUser user) {
		baseUserDao.save(user);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public DataResult<BaseUser> getByEmail(String email) {
		return new SuccessDataResult<BaseUser>(this.baseUserDao.getByEmail(email));
	}

}
