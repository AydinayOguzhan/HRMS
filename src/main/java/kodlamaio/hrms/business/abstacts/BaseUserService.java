package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.BaseUser;

public interface BaseUserService {
	DataResult<List<BaseUser>> getAll();
	DataResult<BaseUser> getByEmail(String email);
	Result add(BaseUser user);
}
