package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserCoverLetterDao;
import kodlamaio.hrms.entities.concretes.UserCoverLetter;

@Service
public class UserCoverLetterManager implements UserCoverLetterService{

	private UserCoverLetterDao userCoverLetterDao;
	
	@Autowired
	public UserCoverLetterManager(UserCoverLetterDao userCoverLetterDao) {
		this.userCoverLetterDao = userCoverLetterDao;
	}

	@Override
	public Result add(UserCoverLetter userCoverLetter) {
		this.userCoverLetterDao.save(userCoverLetter);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(UserCoverLetter userCoverLetter) {
		this.userCoverLetterDao.save(userCoverLetter);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(UserCoverLetter userCoverLetter) {
		this.userCoverLetterDao.delete(userCoverLetter);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<List<UserCoverLetter>> getAll() {
		return new SuccessDataResult<List<UserCoverLetter>>(this.userCoverLetterDao.findAll());
	}

}
