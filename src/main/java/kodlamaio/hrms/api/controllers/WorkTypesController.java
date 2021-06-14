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

import kodlamaio.hrms.business.abstacts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/worktypes")
@CrossOrigin
public class WorkTypesController {
	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkType workType){
		return ResponseEntity.ok(this.workTypeService.add(workType));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody WorkType workType){
		return ResponseEntity.ok(this.workTypeService.update(workType));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody WorkType workType){
		return ResponseEntity.ok(this.workTypeService.delete(workType));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
	
	@GetMapping("/getbyid")
	public  DataResult<WorkType> getById(int id){
		return this.workTypeService.getById(id);
	}
}
