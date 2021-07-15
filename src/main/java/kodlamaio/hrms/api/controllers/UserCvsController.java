package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.Dto.UserCvDto;

@RestController
@RequestMapping("/api/usercvs")
@CrossOrigin
public class UserCvsController {
	private UserCvService userCvService;

	@Autowired
	public UserCvsController(UserCvService userCvService) {
		this.userCvService = userCvService;
	}
	
	@GetMapping("/getusercv")
	public DataResult<UserCvDto> getUserCv(int userId){
		return this.userCvService.getUserCv(userId);
	}
}
