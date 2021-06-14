package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkingTimeType;

public interface WorkingTimeTypeDao extends JpaRepository<WorkingTimeType, Integer>{
	WorkingTimeType getById(int id);
}
