package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ProgrammingLanguage programmingLanguage){
		return ResponseEntity.ok(this.programmingLanguageService.add(programmingLanguage));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody ProgrammingLanguage programmingLanguage){
		return ResponseEntity.ok(this.programmingLanguageService.update(programmingLanguage));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody ProgrammingLanguage programmingLanguage){
		return ResponseEntity.ok(this.programmingLanguageService.delete(programmingLanguage));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<ProgrammingLanguage>> getAll(){
		return this.programmingLanguageService.getAll();
	}
}
