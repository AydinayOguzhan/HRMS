package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserLanguageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserLanguageDao;
import kodlamaio.hrms.entities.concretes.UserLanguage;

@Service
public class UserLanguageManager implements UserLanguageService{

	private UserLanguageDao userLanguageDao;

	@Autowired
	public UserLanguageManager(UserLanguageDao userLanguageDao) {
		this.userLanguageDao = userLanguageDao;
	}

	@Override
	public Result add(UserLanguage userLanguage) {
		this.userLanguageDao.save(userLanguage);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(UserLanguage userLanguage) {
		this.userLanguageDao.save(userLanguage);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(UserLanguage userLanguage) {
		this.userLanguageDao.delete(userLanguage);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<UserLanguage>> getAll() {
		return new SuccessDataResult<List<UserLanguage>>(this.userLanguageDao.findAll());
	}

	@Override
	public DataResult<List<UserLanguage>> getByUserId(int userId) {
		return new SuccessDataResult<List<UserLanguage>>(this.userLanguageDao.getByUserId(userId));
	}

}
