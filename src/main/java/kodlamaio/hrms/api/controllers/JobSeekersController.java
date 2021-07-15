package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeeker jobSeeker){
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> GetAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("/emailverification")
	public Result EmailVerification(@RequestParam int userId, @RequestParam String code) {
		return this.jobSeekerService.emailVerification(userId, code);
	};
	
	@GetMapping("/getbyuserid")
	public Result GetByUserId(@RequestParam int userId) {
		return this.jobSeekerService.getByUserId(userId);
	};
}
