package kodlamaio.hrms.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.VerifyPersonService;
import kodlamaio.hrms.mernis.abstracts.MernisService;

@Service
public class MernisAdapter implements VerifyPersonService{
	
	private MernisService mernisService;
	
	@Autowired
	public MernisAdapter(MernisService mernisService) {
		this.mernisService = mernisService;
	}

	@Override
	public boolean verifyPerson(String nationalityId, String firstName, String lastName, Date dateOfBirth) {
		var result = mernisService.verify(nationalityId, firstName, lastName, dateOfBirth);
		if (!result) {
			return false;			
		}
		return true;
	}

}
