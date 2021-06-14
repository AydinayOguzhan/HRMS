package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingTimeType;

public interface WorkingTimeTypeService {
	Result add(WorkingTimeType workingTimeType);
	Result update(WorkingTimeType workingTimeType);
	Result delete(WorkingTimeType workingTimeType);
	
	DataResult<List<WorkingTimeType>> getAll();
	DataResult<WorkingTimeType> getById(int id);
}
