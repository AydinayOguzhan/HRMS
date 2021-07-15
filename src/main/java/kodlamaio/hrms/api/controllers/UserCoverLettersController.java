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

import kodlamaio.hrms.business.abstacts.UserCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserCoverLetter;

@RestController
@RequestMapping("/api/usercoverletters")
@CrossOrigin
public class UserCoverLettersController {
	private UserCoverLetterService userCoverLetterService;

	@Autowired
	public UserCoverLettersController(UserCoverLetterService userCoverLetterService) {
		this.userCoverLetterService = userCoverLetterService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserCoverLetter userCoverLetter){
		return ResponseEntity.ok(this.userCoverLetterService.add(userCoverLetter));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserCoverLetter userCoverLetter){
		return ResponseEntity.ok(this.userCoverLetterService.update(userCoverLetter));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserCoverLetter userCoverLetter){
		return ResponseEntity.ok(this.userCoverLetterService.delete(userCoverLetter));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<UserCoverLetter>> getAll(){
		return this.userCoverLetterService.getAll();
	}
	
	@GetMapping("/getbyuserid")
	public  DataResult<UserCoverLetter> getByUserId(@RequestParam int userId){
		return this.userCoverLetterService.getByUserId(userId);
	}
}
