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

import kodlamaio.hrms.business.abstacts.UserLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserLink;

@RestController
@RequestMapping("/api/userlinks")
@CrossOrigin
public class UserLinksController {
	private UserLinkService userLinkService;
	
	@Autowired
	public UserLinksController(UserLinkService userLinkService) {
		this.userLinkService = userLinkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody UserLink userLink){
		return ResponseEntity.ok(this.userLinkService.add(userLink));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserLink userLink){
		return ResponseEntity.ok(this.userLinkService.update(userLink));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserLink userLink){
		return ResponseEntity.ok(this.userLinkService.delete(userLink));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<UserLink>> getAll(){
		return this.userLinkService.getAll();
	}
	
	@GetMapping("/getbyuserid")
	public  DataResult<List<UserLink>> getByUserId(@RequestParam int userId){
		return this.userLinkService.getByUserId(userId);
	}
}
