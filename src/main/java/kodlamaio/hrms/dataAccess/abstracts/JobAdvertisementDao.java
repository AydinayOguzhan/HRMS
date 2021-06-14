package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.Dto.JobAdvertisementDetail;
import kodlamaio.hrms.entities.Dto.JobAdvertisementList;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	JobAdvertisement getById(int advertisementId);
	
	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementList "
			+ "(employer.companyName, position.name, advertisement.numberOfPosition, advertisement.publishDate, advertisement.deadline) "
			+ " From JobAdvertisement as advertisement Inner Join Employer as employer on advertisement.userId = employer.userId "
			+ "Inner Join JobPosition as position on advertisement.jobPositionId = position.id "
			+ "Where advertisement.isActive = true and advertisement.isApproved = true")
	List<JobAdvertisementList> getByIsActiveTrueAndIsApprovedTrueDetail();
	

	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementDetail"
			+ "(advertisement.id, position.name, city.name, advertisement.userId, advertisement.jobDescription, advertisement.minSalary, advertisement.maxSalary, "
			+ "advertisement.numberOfPosition, advertisement.publishDate, advertisement.deadline, advertisement.isActive, workType.type, workingTime.type, advertisement.isApproved) "
			+ " From JobAdvertisement as advertisement Inner Join JobPosition as position on advertisement.jobPositionId = position.id "
			+ "Inner Join City as city on advertisement.cityId = city.id "
			+ "Inner Join WorkType as workType on advertisement.workTypeId = workType.id "
			+ "Inner Join WorkingTimeType as workingTime on advertisement.workingTimeTypeId = workingTime.id "
			+ "Where advertisement.isActive = true and advertisement.isApproved = true")
	List<JobAdvertisementDetail> getByIsActiveTrueAndIsApprovedTrue();
	
	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementList"
			+ "(e.companyName, p.name, a.numberOfPosition, a.publishDate, a.deadline)"
			+ " From Employer as e Inner Join JobAdvertisement as a on e.userId = a.userId "
			+ "Inner Join JobPosition as p on a.jobPositionId = p.id "
			+ "Where a.deadline >= :deadline and a.isActive = true")
	List<JobAdvertisementList> getAllActiveWithDeadline(Date deadline);
	
	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementList"
			+ "(e.companyName, p.name, a.numberOfPosition, a.publishDate, a.deadline)"
			+ " From Employer as e Inner Join JobAdvertisement as a on e.userId = a.userId "
			+ "Inner Join JobPosition as p on a.jobPositionId = p.id "
			+ "Where e.companyName = :companyName and a.isActive = true")
	List<JobAdvertisementList> getAllActiveWithCompanyName(String companyName);
	
	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementDetail"
			+ "(advertisement.id, position.name, city.name, advertisement.userId, advertisement.jobDescription, advertisement.minSalary, advertisement.maxSalary, "
			+ "advertisement.numberOfPosition, advertisement.publishDate, advertisement.deadline, advertisement.isActive, workType.type, workingTime.type, advertisement.isApproved) "
			+ " From JobAdvertisement as advertisement Inner Join JobPosition as position on advertisement.jobPositionId = position.id "
			+ "Inner Join City as city on advertisement.cityId = city.id "
			+ "Inner Join WorkType as workType on advertisement.workTypeId = workType.id "
			+ "Inner Join WorkingTimeType as workingTime on advertisement.workingTimeTypeId = workingTime.id "
			+ "Where advertisement.userId = :userId")
	List<JobAdvertisementDetail> getAllDetailByUserId(int userId);
	
	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementDetail"
			+ "(advertisement.id, position.name, city.name, advertisement.userId, advertisement.jobDescription, advertisement.minSalary, advertisement.maxSalary, "
			+ "advertisement.numberOfPosition, advertisement.publishDate, advertisement.deadline, advertisement.isActive, workType.type, workingTime.type, advertisement.isApproved) "
			+ " From JobAdvertisement as advertisement Inner Join JobPosition as position on advertisement.jobPositionId = position.id "
			+ "Inner Join City as city on advertisement.cityId = city.id "
			+ "Inner Join WorkType as workType on advertisement.workTypeId = workType.id "
			+ "Inner Join WorkingTimeType as workingTime on advertisement.workingTimeTypeId = workingTime.id "
			+ "Where advertisement.id = :id")
	JobAdvertisementDetail getDetailById(int id);
}
