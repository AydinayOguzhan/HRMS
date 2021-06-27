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

import kodlamaio.hrms.business.abstacts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {
	private FavoriteService favoriteService;

	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Favorite favorite){
		return ResponseEntity.ok(this.favoriteService.add(favorite));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Favorite favorite){
		return ResponseEntity.ok(this.favoriteService.update(favorite));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Favorite favorite){
		return ResponseEntity.ok(this.favoriteService.delete(favorite));
	}
	
	
	@GetMapping("/getall")
	public  DataResult<List<Favorite>> getAll(){
		return this.favoriteService.getAll();
	}
}
