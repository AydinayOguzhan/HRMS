package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="jobseekers")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class JobSeeker {

	@Id
	@Column(name="userid")
	private int userId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="nationalityid")
	private String nationalityId;
	
	@Column(name="dateofbirth")
	private Date dateOfBirth;
	
	@Column(name="is_verified")
	private boolean isVerified;
}
