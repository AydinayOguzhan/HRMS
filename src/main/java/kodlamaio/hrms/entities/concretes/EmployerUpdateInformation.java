package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employer_update_informations")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class EmployerUpdateInformation {

	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_approved")
	private boolean isApproved;
	
	@Column(name="mail_verification")
	private boolean mailVerified;
	
	@Column(name="is_updated")
	private boolean isUpdated;
}
