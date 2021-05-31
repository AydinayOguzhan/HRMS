package kodlamaio.hrms.business.abstacts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;


public interface CityService {
	Result add(City city);
	Result update(City city);
	Result delete(City city);
	
	DataResult<List<City>> getAll();
}
