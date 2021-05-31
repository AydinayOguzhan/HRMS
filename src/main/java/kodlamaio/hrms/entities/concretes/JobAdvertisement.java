package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="jobadvertisement")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="number_of_position")
	private int numberOfPosition;
	
	@Column(name="publish_date")
	private Date publishDate;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="is_active")
	private boolean isActive;
}
