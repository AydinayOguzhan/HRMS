package kodlamaio.hrms.business.abstacts;

import java.util.Date;

public interface VerifyPersonService {
	boolean verifyPerson(String nationalityId, String firstName, String lastName, Date dateOfBirth);
}
