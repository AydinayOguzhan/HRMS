package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserJobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserJobExperienceDao;
import kodlamaio.hrms.entities.concretes.UserJobExperience;

@Service
public class UserJobExperienceManager implements UserJobExperienceService{
	private UserJobExperienceDao userJobExperienceDao;
	
	@Autowired
	public UserJobExperienceManager(UserJobExperienceDao userJobExperienceDao) {
		this.userJobExperienceDao = userJobExperienceDao;
	}

	@Override
	public DataResult<List<UserJobExperience>> getAll() {
		var result = this.userJobExperienceDao.findAll();
		return new SuccessDataResult<List<UserJobExperience>>(result);
	}

	@Override
	public Result add(UserJobExperience userJobExperience) {
		this.userJobExperienceDao.save(userJobExperience);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(UserJobExperience userJobExperience) {
		this.userJobExperienceDao.save(userJobExperience);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(UserJobExperience userJobExperience) {
		this.userJobExperienceDao.delete(userJobExperience);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<List<UserJobExperience>> getByUserIdOrderByQuitDateDesc(int userId) {
		var result = this.userJobExperienceDao.getByUserIdOrderByQuitDateDesc(userId);
		return new SuccessDataResult<List<UserJobExperience>>(result);
	}

}
