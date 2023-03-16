package com.practice.demo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentUpdateRequest {
	@ApiModelProperty(notes = "Id update request", required = true)
	private String id;
	
	@ApiModelProperty(notes = "First name update request", required = true)
	private String firstName;

	@ApiModelProperty(notes = "Last Name update request", required = true)
	private String lastName;

	@ApiModelProperty(notes = "Email update request", required = true)
	private String email;
	
	@ApiModelProperty(notes = "Phone No update request", required = true)
	private String phoneNo;
	
	@ApiModelProperty(notes = "Dob update request", required = true)
	private long dateOfBirth;

	@ApiModelProperty(notes = "Roll No update request", required = true)
	private Integer rollNo;

	@ApiModelProperty(notes = "Department update request", required = true)
	private String department;
	
	@ApiModelProperty(notes = "Year update request", required = true)
	private String year;
	
	private boolean married;
}
