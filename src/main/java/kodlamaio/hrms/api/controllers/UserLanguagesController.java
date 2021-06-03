package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserLanguage;

@RestController
@RequestMapping("/api/userlanguages")
public class UserLanguagesController {
	private UserLanguageService userLanguageService;
	
	@Autowired
	public UserLanguagesController(UserLanguageService userLanguageService) {
		this.userLanguageService = userLanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserLanguage userLanguage){
		return ResponseEntity.ok(this.userLanguageService.add(userLanguage));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserLanguage userLanguage){
		return ResponseEntity.ok(this.userLanguageService.update(userLanguage));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserLanguage userLanguage){
		return ResponseEntity.ok(this.userLanguageService.delete(userLanguage));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<UserLanguage>> getAll(){
		return this.userLanguageService.getAll();
	}
}
