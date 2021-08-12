package kodlamaio.hrms.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrmsRegisterDto {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
}
