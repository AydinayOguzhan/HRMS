package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}


	@Override
	public DataResult<JobPosition> findByNameIsNull(String name) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByName(name));
	}


	@Override
	public Result add(JobPosition position) {
		var result = this.findByNameIsNull(position.getName());
		if(result.getData() != null) {
			return new ErrorResult("Pozisyon mevcut");
		}
		this.jobPositionDao.save(position);
		return new SuccessResult("Pozisyon sisteme eklendi");			
		
	}


}
