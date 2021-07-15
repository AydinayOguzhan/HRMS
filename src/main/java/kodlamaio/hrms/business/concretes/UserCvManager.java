package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.UserCoverLetterService;
import kodlamaio.hrms.business.abstacts.UserCvService;
import kodlamaio.hrms.business.abstacts.UserImageService;
import kodlamaio.hrms.business.abstacts.UserJobExperienceService;
import kodlamaio.hrms.business.abstacts.UserLanguageService;
import kodlamaio.hrms.business.abstacts.UserLinkService;
import kodlamaio.hrms.business.abstacts.UserProgrammingLanguageService;
import kodlamaio.hrms.business.abstacts.UserSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.Dto.UserCvDto;

@Service
public class UserCvManager implements UserCvService{

	private UserSchoolService userSchoolService;
	private UserJobExperienceService userJobExperienceService;
	private UserLanguageService userLanguageService;
	private UserLinkService userLinkService;
	private UserProgrammingLanguageService userProgrammingLanguageService;
	private UserCoverLetterService userCoverLetterService;
	private UserImageService userImageService;
	
	@Autowired
	public UserCvManager(UserSchoolService userSchoolService, UserJobExperienceService userJobExperienceService,
			UserLanguageService userLanguageService, UserLinkService userLinkService,
			UserProgrammingLanguageService userProgrammingLanguageService,
			UserCoverLetterService userCoverLetterService, UserImageService userImageService) {
		this.userSchoolService = userSchoolService;
		this.userJobExperienceService = userJobExperienceService;
		this.userLanguageService = userLanguageService;
		this.userLinkService = userLinkService;
		this.userProgrammingLanguageService = userProgrammingLanguageService;
		this.userCoverLetterService = userCoverLetterService;
		this.userImageService = userImageService;
	}

	@Override
	public DataResult<UserCvDto> getUserCv(int userId) {
		var userSchools = userSchoolService.getByUserIdOrderByGraduateDateDesc(userId);
		var userJobExperiences = userJobExperienceService.getByUserIdOrderByQuitDateDesc(userId);
		var userLanguages = userLanguageService.getByUserId(userId);
		var userLinks = userLinkService.getByUserId(userId);
		var userProgrammingLanguages = userProgrammingLanguageService.getByUserId(userId);
		var userCoverLetter = userCoverLetterService.getByUserId(userId);
		var userImage = userImageService.getByUserId(userId);
		

		UserCvDto userCv = new UserCvDto(userSchools.getData(),userJobExperiences.getData(), userLanguages.getData(),
				userLinks.getData(), userProgrammingLanguages.getData(), userCoverLetter.getData().getLetter(),
				userImage.getData().getImageLink());
		
		
		return new SuccessDataResult<UserCvDto>(userCv, "Getirme işlemi başarılı");
	}

}
