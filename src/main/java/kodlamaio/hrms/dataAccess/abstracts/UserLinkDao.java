package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserLink;

public interface UserLinkDao extends JpaRepository<UserLink, Integer>{
	List<UserLink> getByUserId(int userId);
}
