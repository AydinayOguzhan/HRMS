package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserSchool;

@RestController
@RequestMapping("/api/userschools")
public class UserSchoolsController {
	private UserSchoolService userService;

	@Autowired
	public UserSchoolsController(UserSchoolService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserSchool userSchool){
		return ResponseEntity.ok(this.userService.update(userSchool));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserSchool userSchool){
		return ResponseEntity.ok(this.userService.update(userSchool));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserSchool userSchool){
		return ResponseEntity.ok(this.userService.delete(userSchool));
	}
	
	@GetMapping("/getall")
	public DataResult<List<UserSchool>> getAll(){
		return this.userService.getAll();
	}

	@GetMapping("/getbyuseridorderbygraduatedatedesc")
	 public DataResult<List<UserSchool>> getByUserIdOrderByGraduateDateDesc(@RequestParam int userId){
		 return this.userService.getByUserIdOrderByGraduateDateDesc(userId);
	 }
}
