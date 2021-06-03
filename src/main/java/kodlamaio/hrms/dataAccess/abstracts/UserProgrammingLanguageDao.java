package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserProgrammingLanguage;

public interface UserProgrammingLanguageDao extends JpaRepository<UserProgrammingLanguage, Integer>{

}
