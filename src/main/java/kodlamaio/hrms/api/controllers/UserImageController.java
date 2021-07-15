package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserImage;

@RestController
@RequestMapping("/api/userimages")
@CrossOrigin
public class UserImageController {
	
	private UserImageService userImageService;
	
	@Autowired
	public UserImageController(UserImageService userImageService) {
		this.userImageService = userImageService;
	}

	@GetMapping("/getimagebyuserid")
	public DataResult<UserImage> getimagebyuserid(@RequestParam int userId){
		return this.userImageService.getByUserId(userId);
	}
	
}
