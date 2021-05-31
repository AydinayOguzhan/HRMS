package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.Dto.JobAdvertisementList;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.update(jobAdvertisement));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.delete(jobAdvertisement));
	}
	
	@GetMapping("/getall")
	public  DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallactive")
	public  DataResult<List<JobAdvertisementList>> getAllActive(){
		return this.jobAdvertisementService.getAllActive();
	}
	
	@GetMapping("/getAllActiveWithDeadline")
	public  DataResult<List<JobAdvertisementList>> getAllActiveWithDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date deadline){
		return this.jobAdvertisementService.getAllActiveWithDeadline(deadline);
	}
	
	@GetMapping("/getAllActiveWithCompanyName")
	public  DataResult<List<JobAdvertisementList>> getAllActiveWithCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getAllActiveWithCompanyName(companyName);
	}
	
	
	@PostMapping("/closeadvertisement")
	public ResponseEntity<?> CloseAdvertisement(@RequestParam int advertisementId){
		return ResponseEntity.ok(this.jobAdvertisementService.closeAdvertisement(advertisementId));
	}
}
