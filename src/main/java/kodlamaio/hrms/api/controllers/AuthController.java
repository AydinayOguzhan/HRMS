package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Dto.EmployerRegisterDto;
import kodlamaio.hrms.entities.Dto.JobSeekerRegisterDto;

@RestController
@RequestMapping("/api/auth")
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
}