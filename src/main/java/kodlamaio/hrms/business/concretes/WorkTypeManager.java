package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.WorkTypeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeDao workTypeDao;

	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		this.workTypeDao = workTypeDao;
	}

	@Override
	public Result add(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult(Messages.addingSuccessful);
	}

	@Override
	public Result update(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult(Messages.updateSuccessful);
	}

	@Override
	public Result delete(WorkType workType) {
		this.workTypeDao.delete(workType);
		return new SuccessResult(Messages.deleteSuccessful);
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll());
	}

	@Override
	public DataResult<WorkType> getById(int id) {
		return new SuccessDataResult<WorkType>(this.workTypeDao.getById(id));
	}

}
