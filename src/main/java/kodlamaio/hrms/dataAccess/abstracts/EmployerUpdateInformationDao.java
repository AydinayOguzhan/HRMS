package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerUpdateInformation;

public interface EmployerUpdateInformationDao extends JpaRepository<EmployerUpdateInformation, Integer>{
	EmployerUpdateInformation getByUserId(int userId);
}
