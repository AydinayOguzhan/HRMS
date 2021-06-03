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

@Data
@Entity
@Table(name="userjobexperiences")
@AllArgsConstructor
@NoArgsConstructor
public class UserJobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="quit_date")
	private Date quitDate;
}
