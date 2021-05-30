package kodlamaio.hrms.entities.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerRegisterDto {
	
	private String email;
	private String password;
	private String verifyPassword;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private Date dateOfBirth;
}
