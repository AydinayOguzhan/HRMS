package kodlamaio.hrms.mernis.abstracts;

import java.util.Date;

public interface MernisService {
	boolean verify(String nationalityId, String firstName, String lastName, Date dateOfBirth);
}
