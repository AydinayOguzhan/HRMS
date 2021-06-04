package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserCoverLetter;

public interface UserCoverLetterDao extends JpaRepository<UserCoverLetter, Integer>{
	UserCoverLetter getByUserId(int userId);
}
