package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstacts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/imageupload")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders="*", allowCredentials = "true")
public class ImageUploadController {
	private ImageService imageService;

	@Autowired
	public ImageUploadController(ImageService imageService) {
		this.imageService = imageService;
	}

//	@RequestMapping(value= "/api/**", method=RequestMethod.OPTIONS)
//	public void corsHeaders(HttpServletResponse response) {
//	    response.addHeader("Access-Control-Allow-Origin", "*");
//	    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//	    response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
//	    response.addHeader("Access-Control-Max-Age", "3600");
//	}
//	
	
	@PostMapping("/saveimage")
	@CrossOrigin
	public ResponseEntity<?> add( @RequestParam("file") MultipartFile file, @RequestParam int userId) throws IOException {
		return ResponseEntity.ok(this.imageService.uploadImage(file, userId));
	}

	
	@PostMapping("/deleteimage")
	public ResponseEntity<?> delete(@RequestParam int userId) throws Exception {
		return ResponseEntity.ok(this.imageService.deleteImage(userId));
	}
	
	@GetMapping("getimagebyuserid")
	public DataResult<String> getimagebyuserid(@RequestParam int userId){
		return this.imageService.getUserImage(userId);
	}
	
}
