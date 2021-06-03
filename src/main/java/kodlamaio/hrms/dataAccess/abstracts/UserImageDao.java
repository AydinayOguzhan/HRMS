package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserImage;

public interface UserImageDao extends JpaRepository<UserImage, Integer>{
	UserImage getByUserId(int userId);
}
