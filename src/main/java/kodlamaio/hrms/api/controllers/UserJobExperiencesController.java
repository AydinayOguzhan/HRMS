package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserJobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserJobExperience;

@RestController
@RequestMapping("/api/userjobexperiences")
public class UserJobExperiencesController {
	private UserJobExperienceService userJobExperienceService;

	@Autowired
	public UserJobExperiencesController(UserJobExperienceService userJobExperienceService) {
		this.userJobExperienceService = userJobExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserJobExperience userJobExperience){
		return ResponseEntity.ok(this.userJobExperienceService.add(userJobExperience));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserJobExperience userJobExperience){
		return ResponseEntity.ok(this.userJobExperienceService.update(userJobExperience));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserJobExperience userJobExperience){
		return ResponseEntity.ok(this.userJobExperienceService.delete(userJobExperience));
	}
	
	@GetMapping("/getall")
	public DataResult<List<UserJobExperience>> getAll(){
		return this.userJobExperienceService.getAll();
	}
	
	@GetMapping("/getbyuseridorderbyquitdatedesc")
	public DataResult<List<UserJobExperience>> getByUserIdOrderByQuitDateDesc(int userId){
		return this.userJobExperienceService.getByUserIdOrderByQuitDateDesc(userId);
	}
}
