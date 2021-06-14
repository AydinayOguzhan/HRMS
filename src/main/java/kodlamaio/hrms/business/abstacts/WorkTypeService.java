package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	Result add(WorkType workType);
	Result update(WorkType workType);
	Result delete(WorkType workType);
	
	DataResult<List<WorkType>> getAll();
	DataResult<WorkType> getById(int id);
}
