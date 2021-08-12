package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.EmployerUpdateInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployerUpdateInformation;

@RestController
@RequestMapping("/api/employerUpdateInformations")
@CrossOrigin
public class EmployerUpdateInformationsController {
	private EmployerUpdateInformationService employerUpdateInformationService;
	
	@Autowired
	public EmployerUpdateInformationsController(EmployerUpdateInformationService employerUpdateInformationService) {
		this.employerUpdateInformationService = employerUpdateInformationService;
	}

	@GetMapping("/getall")
	public DataResult<List<EmployerUpdateInformation>> GetAll(){
		return this.employerUpdateInformationService.getAll();
	}
}
