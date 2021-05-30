package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Employer {

	@Id
	@Column(name="userid")
	private int userId;
	
	@Column(name="companyname")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column(name="isapproved")
	private boolean isApproved;
	
	@Column(name="mailverified")
	private boolean mailVerified;
}
