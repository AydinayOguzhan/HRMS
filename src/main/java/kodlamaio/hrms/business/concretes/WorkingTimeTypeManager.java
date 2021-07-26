package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.WorkingTimeTypeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeTypeDao;
import kodlamaio.hrms.entities.concretes.WorkingTimeType;

@Service
public class WorkingTimeTypeManager implements WorkingTimeTypeService{

	private WorkingTimeTypeDao workingTimeTypeDao;
	
	@Autowired
	public WorkingTimeTypeManager(WorkingTimeTypeDao workingTimeTypeDao) {
		this.workingTimeTypeDao = workingTimeTypeDao;
	}

	@Override
	public Result add(WorkingTimeType workingTimeType) {
		this.workingTimeTypeDao.save(workingTimeType);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(WorkingTimeType workingTimeType) {
		this.workingTimeTypeDao.save(workingTimeType);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(WorkingTimeType workingTimeType) {
		this.workingTimeTypeDao.delete(workingTimeType);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<WorkingTimeType>> getAll() {
		return new SuccessDataResult<List<WorkingTimeType>>(this.workingTimeTypeDao.findAll());
	}

	@Override
	public DataResult<WorkingTimeType> getById(int id) {
		return new SuccessDataResult<WorkingTimeType>(this.workingTimeTypeDao.getById(id));
	}

}
