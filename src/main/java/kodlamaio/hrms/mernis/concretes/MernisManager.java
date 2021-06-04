package kodlamaio.hrms.mernis.concretes;

import java.util.Date;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.mernis.abstracts.MernisService;

@Service
public class MernisManager implements MernisService{

	@Override
	public boolean verify(String nationalityId, String firstName, String lastName, Date dateOfBirth) {
//		if (firstName.equals("string")) {
//			return true;
//		}
		if (!nationalityId.isEmpty() || !firstName.isEmpty() || !lastName.isEmpty() || dateOfBirth != null) {
			return true;
		}
		return false;
	}

}
