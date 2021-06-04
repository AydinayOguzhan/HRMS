package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserLinkDao;
import kodlamaio.hrms.entities.concretes.UserLink;

@Service
public class UserLinkManager implements UserLinkService{

	private UserLinkDao userLinkDao;

	@Autowired
	public UserLinkManager(UserLinkDao userLinkDao) {
		this.userLinkDao = userLinkDao;
	}

	@Override
	public Result add(UserLink userLink) {
		this.userLinkDao.save(userLink);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(UserLink userLink) {
		this.userLinkDao.save(userLink);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(UserLink userLink) {
		this.userLinkDao.delete(userLink);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<List<UserLink>> getAll() {
		return new SuccessDataResult<List<UserLink>>(this.userLinkDao.findAll());
	}

	@Override
	public DataResult<List<UserLink>> getByUserId(int userId) {
		return new SuccessDataResult<List<UserLink>>(this.userLinkDao.getByUserId(userId));
	}

}
