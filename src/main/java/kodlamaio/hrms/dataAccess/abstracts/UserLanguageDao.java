package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserLanguage;

public interface UserLanguageDao extends JpaRepository<UserLanguage, Integer>{

}
