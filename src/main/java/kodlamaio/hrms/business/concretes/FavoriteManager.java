package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.FavoriteService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService{

	private FavoriteDao favoriteDao;
	
	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Result add(Favorite favorite) {
		favoriteDao.save(favorite);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(Favorite favorite) {
		favoriteDao.save(favorite);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(Favorite favorite) {
		favoriteDao.delete(favorite);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<Favorite>> getAll() {
		return new SuccessDataResult<List<Favorite>>(favoriteDao.findAll());
	}

}
