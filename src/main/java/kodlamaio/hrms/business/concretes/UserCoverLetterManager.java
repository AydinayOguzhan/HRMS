package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserCoverLetterService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
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
		var result = getByUserId(userCoverLetter.getUserId());
		if (result.getData() != null) {
			return new ErrorResult(Messages.alreadyHaveCoverLetter);
		}
		
		this.userCoverLetterDao.save(userCoverLetter);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(UserCoverLetter userCoverLetter) {
		this.userCoverLetterDao.save(userCoverLetter);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(UserCoverLetter userCoverLetter) {
		this.userCoverLetterDao.delete(userCoverLetter);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<UserCoverLetter>> getAll() {
		return new SuccessDataResult<List<UserCoverLetter>>(this.userCoverLetterDao.findAll());
	}

	@Override
	public DataResult<UserCoverLetter> getByUserId(int userId) {
		var result = this.userCoverLetterDao.getByUserId(userId);
		if (result == null) {
			var newResult = new UserCoverLetter();
			newResult.setUserId(userId);
			newResult.setLetter("");
			return new SuccessDataResult<UserCoverLetter>(newResult);
		}
		return new SuccessDataResult<UserCoverLetter>(result);
	}

}
