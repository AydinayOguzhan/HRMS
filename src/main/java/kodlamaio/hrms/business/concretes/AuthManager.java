package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstacts.AuthService;
import kodlamaio.hrms.business.abstacts.BaseUserService;
import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.business.abstacts.JobSeekerService;
import kodlamaio.hrms.business.abstacts.SystemPersonnelService;
import kodlamaio.hrms.business.abstacts.VerificationCodeService;
import kodlamaio.hrms.business.abstacts.VerifyPersonService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.Dto.EmployerRegisterDto;
import kodlamaio.hrms.entities.Dto.HrmsRegisterDto;
import kodlamaio.hrms.entities.Dto.JobSeekerRegisterDto;
import kodlamaio.hrms.entities.concretes.BaseUser;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;


@Service
public class AuthManager implements AuthService{

	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private BaseUserService baseUserService;
	private VerificationCodeService verificationCodeService;
	private VerifyPersonService verifyPersonService;
	private SystemPersonnelService systemPersonnelService;

	public AuthManager(EmployerService employerService, BaseUserService baseUserService,
			VerificationCodeService verificationCodeService, JobSeekerService jobSeekerService,
			VerifyPersonService verifyPersonService, SystemPersonnelService systemPersonnelService) {
		this.employerService = employerService;
		this.baseUserService = baseUserService;
		this.verificationCodeService = verificationCodeService;
		this.jobSeekerService = jobSeekerService;
		this.verifyPersonService = verifyPersonService;
		this.systemPersonnelService = systemPersonnelService;
	}
	//------------------------------------------------------------------------------------------------------------
	@Override
	public Result registerEmployer(EmployerRegisterDto employerRegisterDto) {
		var nullParameters = checkEmployerParametersIfItsNull(employerRegisterDto);
		if (!nullParameters.isSuccess()) {
			return new ErrorResult(Messages.fillTheBlanks);
		}
		var ifCompanyEmail = checkIfItsCompanyEmail(employerRegisterDto.getCompanyEmail(), employerRegisterDto.getWebsite());
		if (!ifCompanyEmail.isSuccess()) {
			return new ErrorResult(Messages.enterCompanyEmail);
		}
		var checkUser = checkIfUserExist(employerRegisterDto.getCompanyEmail());
		if (!checkUser.isSuccess()) {
			return new ErrorResult(Messages.userAlreadyInTheSystem);
		}
		if (!employerRegisterDto.getPassword().contains(employerRegisterDto.getVerifyPassword())) {
			return new ErrorResult(Messages.passwordsDontMatch);
		}
		
		
		var baseUser = fillUser(employerRegisterDto.getCompanyEmail(), employerRegisterDto.getPassword());
		baseUserService.add(baseUser);
		
		var user = this.baseUserService.getByEmail(employerRegisterDto.getCompanyEmail());
		Employer employer = new Employer(user.getData().getId(),employerRegisterDto.getCompanyName(), 
				employerRegisterDto.getWebsite(), employerRegisterDto.getPhoneNumber(),false,false,false);
		employerService.add(employer);
		
		var code = this.verificationCodeService.createVerificationCode();
		var verificationCode = verificationCodeService.setVerificationCode(code.getData(), user.getData().getId());
		verificationCodeService.add(verificationCode.getData());
		
		return new SuccessResult(Messages.registrationSuccessful);
	}
	//------------------------------------------------------------------------------------------------------------
	
	@Override
	public Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto) {
		var nullParameters = checkJobSeekerParameterIfItsNull(jobSeekerRegisterDto);
		if (!nullParameters.isSuccess()) {
			return new ErrorResult(Messages.fillTheBlanks);
		}
		var checkUserMail = checkIfUserExist(jobSeekerRegisterDto.getEmail());
		var checkUserNationalityId = checkIfUserExistWithNationalityId(jobSeekerRegisterDto.getNationalityId());
		if (!checkUserMail.isSuccess() || !checkUserNationalityId.isSuccess()) {
			return new ErrorResult(Messages.userAlreadyInTheSystem);
		}
		
		var verify = verifyPersonService.verifyPerson(jobSeekerRegisterDto.getNationalityId(), jobSeekerRegisterDto.getFirstName(), 
				jobSeekerRegisterDto.getLastName(), jobSeekerRegisterDto.getDateOfBirth());
		
		if (!verify) {
			return new ErrorResult(Messages.notAValidPerson);
		}
		
		if (!jobSeekerRegisterDto.getPassword().contains(jobSeekerRegisterDto.getVerifyPassword())) {
			return new ErrorResult(Messages.passwordsDontMatch);
		}
		
		var baseUser = fillUser(jobSeekerRegisterDto.getEmail(), jobSeekerRegisterDto.getPassword());
		baseUserService.add(baseUser);
		
		var user = this.baseUserService.getByEmail(jobSeekerRegisterDto.getEmail());
		JobSeeker jobSeeker = new JobSeeker(user.getData().getId(), jobSeekerRegisterDto.getFirstName(), 
				jobSeekerRegisterDto.getLastName(), jobSeekerRegisterDto.getNationalityId(), 
				jobSeekerRegisterDto.getDateOfBirth(), false);
		jobSeekerService.add(jobSeeker);
		
		var code = this.verificationCodeService.createVerificationCode();
		var verificationCode = verificationCodeService.setVerificationCode(code.getData(), user.getData().getId());
		verificationCodeService.add(verificationCode.getData());
		
		return new SuccessResult(Messages.registrationSuccessful);
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	
	@Override
	public Result Login(BaseUser baseUser) {
		var result = this.baseUserService.getByEmail(baseUser.getEmail());
		if (result.getData() == null) {
			return new ErrorResult(Messages.userDoesntExist);
		}
		else if (!result.getData().getPassword().equals(baseUser.getPassword())) {
			return new ErrorResult(Messages.wrongPassword);
		}
		return new SuccessResult(Messages.loginSuccessful);
	};
	
	//------------------------------------------------------------------------------------------------------------
	
	@Override
	public Result registerHrmsPersonnel(HrmsRegisterDto hrmsRegisterDto) {
		BaseUser baseUser = new BaseUser();
		baseUser.setEmail(hrmsRegisterDto.getEmail());
		baseUser.setPassword(hrmsRegisterDto.getPassword());
		var baseUserResult = baseUserService.add(baseUser);
		var getUserResult = baseUserService.getByEmail(hrmsRegisterDto.getEmail());
		
		SystemPersonnel systemPersonnel = new SystemPersonnel();
		systemPersonnel.setFirstName(hrmsRegisterDto.getFirstName());
		systemPersonnel.setLastName(hrmsRegisterDto.getLastName());
		systemPersonnel.setUserId(getUserResult.getData().getId());
		var hrmsResult = systemPersonnelService.add(systemPersonnel);
		
		if (baseUserResult.isSuccess() && hrmsResult.isSuccess()) {
			return new SuccessResult(Messages.successful);
		}
		return new ErrorResult(Messages.unsuccessful);
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	private BaseUser fillUser(String email, String password) {
		BaseUser baseUser = new BaseUser();
		baseUser.setEmail(email);
		baseUser.setPassword(password);
		return baseUser;
	}
	
	private Result checkIfItsCompanyEmail(String email, String website) {
		var index= email.indexOf("@");
		var domain = email.substring(index+ 1);
		
		var result = website.compareTo(domain);
		if (result != 0) {
			return new ErrorResult();
		}
		return new SuccessResult();
		
	}
	
	private Result checkIfUserExist(String email) {
		var user = this.baseUserService.getByEmail(email);
		if (user.getData() != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result checkIfUserExistWithNationalityId(String nationalityId) {
		var user = this.jobSeekerService.getByNationalityId(nationalityId);
		if (user.getData() != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result checkEmployerParametersIfItsNull(EmployerRegisterDto dto) {
		if (dto.getCompanyEmail().isEmpty() || dto.getCompanyName().isEmpty() || dto.getPassword().isEmpty() ||
				dto.getVerifyPassword().isEmpty() || dto.getPhoneNumber().isEmpty() || dto.getWebsite().isEmpty()) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result checkJobSeekerParameterIfItsNull(JobSeekerRegisterDto dto) {
		if (dto.getEmail().isEmpty() || dto.getFirstName().isEmpty() || dto.getLastName().isEmpty() || 
				dto.getNationalityId().isEmpty() || dto.getPassword().isEmpty() || dto.getVerifyPassword().isEmpty() ||
				dto.getDateOfBirth() == null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}


}
