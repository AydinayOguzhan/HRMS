package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Language language){
		return ResponseEntity.ok(this.languageService.add(language));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Language language){
		return ResponseEntity.ok(this.languageService.update(language));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Language language){
		return ResponseEntity.ok(this.languageService.delete(language));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
}
