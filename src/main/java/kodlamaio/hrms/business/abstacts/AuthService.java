package kodlamaio.hrms.business.abstacts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Dto.EmployerRegisterDto;
import kodlamaio.hrms.entities.Dto.HrmsRegisterDto;
import kodlamaio.hrms.entities.Dto.JobSeekerRegisterDto;
import kodlamaio.hrms.entities.concretes.BaseUser;

public interface AuthService {
	Result registerEmployer(EmployerRegisterDto employerRegisterDto);
	Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto);
	Result registerHrmsPersonnel(HrmsRegisterDto hrmsRegisterDto);
	Result Login(BaseUser baseUser);
}
