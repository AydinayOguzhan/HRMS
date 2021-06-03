package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserLink;

public interface UserLinkService {
	Result add(UserLink userLink);
	Result update(UserLink userLink);
	Result delete(UserLink userLink);
	
	DataResult<List<UserLink>> getAll();
}
