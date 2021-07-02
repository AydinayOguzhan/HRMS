package kodlamaio.hrms.entities.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDetail {

	private int id;
	private String jobPositionName;
	private String cityName;
	private int userId;
	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private int numberOfPosition;
	private Date publishDate;
	private Date deadline;
	private boolean isActive;
	private String workTypeName;
	private String workingTimeTypeName;
	private boolean isApproved;
	private String companyName;	
	private String webSite;
	private String phoneNumber;
	
}
