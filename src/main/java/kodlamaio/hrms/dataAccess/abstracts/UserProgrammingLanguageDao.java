package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserProgrammingLanguage;

public interface UserProgrammingLanguageDao extends JpaRepository<UserProgrammingLanguage, Integer>{
	List<UserProgrammingLanguage> getByUserId(int userId);
}
