package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserLanguage;

public interface UserLanguageDao extends JpaRepository<UserLanguage, Integer>{
	List<UserLanguage> getByUserId(int userId);
}
