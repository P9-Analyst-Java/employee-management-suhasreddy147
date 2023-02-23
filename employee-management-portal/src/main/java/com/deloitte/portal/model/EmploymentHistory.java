package com.deloitte.portal.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmploymentHistory {
	
	private int id;
	private int empId;
	private String organizationName;
	private Date fromDate;
	private Date untilDate;
	private String location;
	private String country;
	private String post;
	private String skillUsed;
}
