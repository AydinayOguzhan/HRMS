package kodlamaio.hrms.entities.Dto;

import java.util.List;

import kodlamaio.hrms.entities.concretes.UserJobExperience;
import kodlamaio.hrms.entities.concretes.UserLanguage;
import kodlamaio.hrms.entities.concretes.UserLink;
import kodlamaio.hrms.entities.concretes.UserProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.UserSchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCvDto {
		
	private List<UserSchool> userSchools;
	
	private List<UserJobExperience> userJobExperiences;
	
	private List<UserLanguage> userLanguages;
	
	private List<UserLink> userLinks;
	
	private List<UserProgrammingLanguage> userProgrammingLanguage;
	
	private String userCoverLetter;
	
	private String userImage;
}
