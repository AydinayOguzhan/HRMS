package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Dto.EmployerRegisterDto;
import kodlamaio.hrms.entities.Dto.HrmsRegisterDto;
import kodlamaio.hrms.entities.Dto.JobSeekerRegisterDto;
import kodlamaio.hrms.entities.concretes.BaseUser;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	};
	
	@PostMapping("/registerEmployer")
	public Result RegisterEmployer(@RequestBody EmployerRegisterDto employerRegisterDto) {
		return this.authService.registerEmployer(employerRegisterDto);
	}
	
	@PostMapping("/registerjobseeker")
	public Result RegisterJobSeeker(@RequestBody JobSeekerRegisterDto jobSeekerRegisterDto) {
		return this.authService.registerJobSeeker(jobSeekerRegisterDto);
	}
	
	@PostMapping("/registersystempersonnel")
	public Result RegisterSystemPersonnel(@RequestBody HrmsRegisterDto hrmsRegisterDto) {
		return this.authService.registerHrmsPersonnel(hrmsRegisterDto);
	}
	
	@PostMapping("/login")
	public Result Login(@RequestBody BaseUser baseUser) {
		return this.authService.Login(baseUser);
	}
}
