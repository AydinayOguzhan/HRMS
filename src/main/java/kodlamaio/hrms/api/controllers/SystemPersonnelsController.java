package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnels")
@CrossOrigin
public class SystemPersonnelsController {
	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.add(systemPersonnel);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.update(systemPersonnel);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.delete(systemPersonnel);
	}
	
	@GetMapping("/getbyuserid")
	public  DataResult<SystemPersonnel> getByUserId(@RequestParam int userId){
		return this.systemPersonnelService.getByUserId(userId);
	}
	
	@PostMapping("/verification")
	public Result Verification(@RequestParam int userId,@RequestParam boolean verified) {
		return this.systemPersonnelService.verification(userId, verified);
	}
	
	@PostMapping("/verifyjobadvertisement")
	public Result verifyJobAdvertisement(@RequestParam int id,@RequestParam boolean verified) {
		return this.systemPersonnelService.verifyJobAdvertisements(id, verified);
	}
	
	@PostMapping("/approveemployerdataupdate")
	public Result approveEmployerDataUpdate(@RequestParam int userId) {
		return this.systemPersonnelService.approveEmployerDataUpdate(userId);
	}
}
