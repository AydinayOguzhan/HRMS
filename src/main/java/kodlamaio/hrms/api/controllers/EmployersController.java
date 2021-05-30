package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@PostMapping("/update")
	public Result Update(@RequestBody Employer employer){
		return this.employerService.update(employer);
	}
	
	@GetMapping("/emailverification")
	public Result EmailVerification(@RequestParam int userId, @RequestParam String code) {
		return this.employerService.emailVerification(userId, code);
	};
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> GetAll(){
		return this.employerService.getAll();
	}
}
