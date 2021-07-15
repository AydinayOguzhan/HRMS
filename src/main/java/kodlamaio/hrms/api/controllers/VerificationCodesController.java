package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@RestController
@RequestMapping("/api/verificationcodes")
@CrossOrigin
public class VerificationCodesController {
	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		this.verificationCodeService = verificationCodeService;
	}
	
	@GetMapping("/refreshverificationcode")
	public Result RefreshVerificationCode(@RequestParam int userId) {
		return this.verificationCodeService.refreshVerificationCode(userId);
	}
	
	@GetMapping("/getbyuserid")
	public DataResult<List<VerificationCode>> getByUserId(@RequestParam int userId) {
		return this.verificationCodeService.GetAllByUserId(userId);
	}
	
}
