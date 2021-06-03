package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserSchoolDao;
import kodlamaio.hrms.entities.concretes.UserSchool;

@Service
public class UserSchoolManager implements UserSchoolService{

	private UserSchoolDao userSchoolDao;

	@Autowired
	public UserSchoolManager(UserSchoolDao userSchoolDao) {
		this.userSchoolDao = userSchoolDao;
	}

	@Override
	public DataResult<List<UserSchool>> getAll() {
		return new SuccessDataResult<List<UserSchool>>(this.userSchoolDao.findAll());
	}

	@Override
	public Result add(UserSchool userSchool) {
		this.userSchoolDao.save(userSchool);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(UserSchool userSchool) {
		this.userSchoolDao.save(userSchool);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(UserSchool userSchool) {
		this.userSchoolDao.delete(userSchool);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<List<UserSchool>> getByUserIdOrderByGraduateDateDesc(int userId) {
		return new SuccessDataResult<List<UserSchool>>(this.userSchoolDao.getByUserIdOrderByGraduateDateDesc(userId));
	}


	
}
