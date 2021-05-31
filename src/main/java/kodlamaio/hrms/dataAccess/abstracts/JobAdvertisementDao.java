package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.Dto.JobAdvertisementList;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	JobAdvertisement getById(int advertisementId);
	
	@Query("Select new kodlamaio.hrms.entities.Dto.JobAdvertisementList"
			+ "(e.companyName, p.name, a.numberOfPosition, a.publishDate, a.deadline)"
			+ " From Employer as e Inner Join JobAdvertisement as a on e.userId = a.userId "
			+ "Inner Join JobPosition as p on a.jobPositionId = p.id "
			+ "Where a.isActive = true")
	List<JobAdvertisementList> getAllActive();
	
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
}
