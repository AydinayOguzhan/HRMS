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
@Table(name="userimages")
@AllArgsConstructor
@NoArgsConstructor
public class UserImage {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="public_id")
	private String publicId;
	
	@Column(name="image_link")
	private String imageLink;
}
