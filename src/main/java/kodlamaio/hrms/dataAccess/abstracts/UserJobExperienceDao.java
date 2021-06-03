package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserJobExperience;

public interface UserJobExperienceDao extends JpaRepository<UserJobExperience, Integer>{
	List<UserJobExperience> getByUserIdOrderByQuitDateDesc(int userId);
}
