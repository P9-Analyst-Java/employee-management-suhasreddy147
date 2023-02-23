package com.deloitte.portal.model;

import java.sql.Date;


import com.deloitte.portal.validator.BloodGroup;
import com.deloitte.portal.validator.Dob;
import com.deloitte.portal.validator.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
	
	private int empId;
	
	@Pattern(regexp="^[A-Za-z]+$",message="Please input alphabet only!!")
	@Size(min = 1,max = 50,message="Input between 1 to 50 characters!")
	private String firstName;
	
	@Pattern(regexp="^[A-Za-z]+$",message="Please input alphabet only!!")
	@Size(min = 1,max = 50,message="Input between 1 to 50 characters!")
	private String lastName;
	
	@Gender
	private String gender;
	
	@Dob
	private Date dob;
	
	@Pattern(regexp = "^[a-zA-Z0-9]+$",message="Please input alphanumeric only!")
	@Size(min=10,max=10,message="Please input 10 characters only!")
	private String panNum;
	
	@Pattern(regexp = "^[0-9]+$",message="Please input numeric only!")
	@Size(min=12,max=12,message="Please input 12 characters only!")
	private String aadharNum;
	
	@Pattern(regexp = "^[0-9]+$",message="Please input numeric only!")
	@Size(min=10,max=10,message="Please input 10 characters only!")
	private String mobileNum;
	
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Please input a valid email!")
	private String emailId;
	
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Please input a valid email!")
	private String officeMail;
	
    @Size(max=200,message="should not exceed 200 characters")
	private String permanentAddress;
	
    @Size(max=200,message="should not exceed 200 characters")
	private String presentAddress;
	
    @BloodGroup
	private String bloodGroup;

    private Date doj;
	
	@Min(value=7,message="Please select a value between 7 to 13!")
	@Max(value=7,message="Please select a value between 7 to 13!")
	private int empLevel;
	
	@Size(max=30,message="Please input within 30 characters")
	@Pattern(regexp = "^[a-zA-Z ]*$",message="Please input only alphabet and space")
	private String postName;
	
	@Min(value=100,message="Please input  between 3 to 8  characters!!")
	@Max(value=99999999,message="Please input  between 3 to 8  characters!!")
	private int basicPay;
	
	@Min(value=100,message="Please input  between 3 to 5  characters!!")
	@Max(value=99999,message="Please input  between 3 to 5  characters!!")
	private int houseAllowance;
}
