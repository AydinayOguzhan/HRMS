package kodlamaio.hrms.business.abstacts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.Dto.UserCvDto;

public interface UserCvService{
	DataResult<UserCvDto> getUserCv(int userId);
}
