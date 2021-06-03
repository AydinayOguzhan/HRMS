package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserProgrammingLanguage;

@RestController
@RequestMapping("/api/userprogramminglanguages")
public class UserProgrammingLanguagesController {
	private UserProgrammingLanguageService userProgrammingLanguageService;

	@Autowired
	public UserProgrammingLanguagesController(UserProgrammingLanguageService userProgrammingLanguageService) {
		this.userProgrammingLanguageService = userProgrammingLanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserProgrammingLanguage userProgrammingLanguage){
		return ResponseEntity.ok(this.userProgrammingLanguageService.add(userProgrammingLanguage));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserProgrammingLanguage userProgrammingLanguage){
		return ResponseEntity.ok(this.userProgrammingLanguageService.update(userProgrammingLanguage));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserProgrammingLanguage userProgrammingLanguage){
		return ResponseEntity.ok(this.userProgrammingLanguageService.delete(userProgrammingLanguage));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<UserProgrammingLanguage>> getAll(){
		return this.userProgrammingLanguageService.getAll();
	}
}
