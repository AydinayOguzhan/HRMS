package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.BaseUser;

public interface BaseUserDao extends JpaRepository<BaseUser, Integer>{
	BaseUser getByEmail(String email);
}
