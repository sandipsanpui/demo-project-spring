package com.practice.demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "Model Attributes required for subscription Request API")
public class StudentCreateRequest {
	@ApiModelProperty(notes = "First name create request", required = true)
	private String firstName;

	@ApiModelProperty(notes = "Last Name create request", required = true)
	private String lastName;

	@ApiModelProperty(notes = "Email create request", required = true)
	private String email;
	
	@ApiModelProperty(notes = "Phone No create request", required = true)
	private String phoneNo;
	
	@ApiModelProperty(notes = "Dob create request", required = true)
	private long dateOfBirth;

	@ApiModelProperty(notes = "Roll No create request", required = true)
	private Integer rollNo;

	@ApiModelProperty(notes = "Department create request", required = true)
	private String department;
	
	@ApiModelProperty(notes = "Year create request", required = true)
	private String year;
	
	private boolean married;
}
