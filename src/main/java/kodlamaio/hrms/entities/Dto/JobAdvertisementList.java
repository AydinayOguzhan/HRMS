package kodlamaio.hrms.entities.Dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementList {
	private int id;
	private String companyName;
	private String positionName;
	private int numberOfPosition;
	private Date publishDate;
	private Date deadline;
}
