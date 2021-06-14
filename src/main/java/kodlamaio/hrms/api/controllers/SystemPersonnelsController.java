package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {
	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@PostMapping("/verification")
	public Result Verification(@RequestParam int userId,@RequestParam boolean verified) {
		return this.systemPersonnelService.verification(userId, verified);
	}
	
	@PostMapping("/verifyjobadvertisement")
	public Result verifyJobAdvertisement(@RequestParam int id,@RequestParam boolean verified) {
		return this.systemPersonnelService.verifyJobAdvertisements(id, verified);
	}
}
