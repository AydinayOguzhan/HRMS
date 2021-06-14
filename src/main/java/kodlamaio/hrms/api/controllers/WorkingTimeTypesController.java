package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.WorkingTimeTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingTimeType;

@RestController
@RequestMapping("/api/workingtimetypes")
@CrossOrigin
public class WorkingTimeTypesController {
	private WorkingTimeTypeService workingTimeTypeService;

	@Autowired
	public WorkingTimeTypesController(WorkingTimeTypeService workingTimeTypeService) {
		this.workingTimeTypeService = workingTimeTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkingTimeType workingTimeType){
		return ResponseEntity.ok(this.workingTimeTypeService.add(workingTimeType));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody WorkingTimeType workingTimeType){
		return ResponseEntity.ok(this.workingTimeTypeService.update(workingTimeType));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody WorkingTimeType workingTimeType){
		return ResponseEntity.ok(this.workingTimeTypeService.delete(workingTimeType));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<WorkingTimeType>> getAll(){
		return this.workingTimeTypeService.getAll();
	}
	
	@GetMapping("/getbyid")
	public  DataResult<WorkingTimeType> getById(int id){
		return this.workingTimeTypeService.getById(id);
	}
}
