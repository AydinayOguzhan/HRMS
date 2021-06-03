package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="usercoverletters")
@NoArgsConstructor
@AllArgsConstructor
public class UserCoverLetter {

	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="letter")
	private String letter;
	
	
}
