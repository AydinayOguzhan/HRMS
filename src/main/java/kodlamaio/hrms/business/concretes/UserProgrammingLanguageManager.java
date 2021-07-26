package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserProgrammingLanguageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.UserProgrammingLanguage;

@Service
public class UserProgrammingLanguageManager implements UserProgrammingLanguageService{

	private UserProgrammingLanguageDao userProgrammingLanguageDao;
	
	@Autowired
	public UserProgrammingLanguageManager(UserProgrammingLanguageDao userProgrammingLanguageDao) {
		this.userProgrammingLanguageDao = userProgrammingLanguageDao;
	}

	@Override
	public Result add(UserProgrammingLanguage userProgrammingLanguage) {
		this.userProgrammingLanguageDao.save(userProgrammingLanguage);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(UserProgrammingLanguage userProgrammingLanguage) {
		this.userProgrammingLanguageDao.save(userProgrammingLanguage);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(UserProgrammingLanguage userProgrammingLanguage) {
		this.userProgrammingLanguageDao.delete(userProgrammingLanguage);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<UserProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<UserProgrammingLanguage>>(this.userProgrammingLanguageDao.findAll());
	}

	@Override
	public DataResult<List<UserProgrammingLanguage>> getByUserId(int userId) {
		return new SuccessDataResult<List<UserProgrammingLanguage>>(this.userProgrammingLanguageDao.getByUserId(userId));
	}

}
