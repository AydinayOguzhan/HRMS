package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteService {
	Result add(Favorite favorite);
	Result update(Favorite favorite);
	Result delete(Favorite favorite);
	
	DataResult<List<Favorite>> getAll();
}
