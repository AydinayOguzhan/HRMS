package kodlamaio.hrms.entities.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class EmployerRegisterDto{
	
	private String password;
	private String verifyPassword;
	private String companyEmail;
	private String companyName;
	private String website;
	private String phoneNumber;

}
