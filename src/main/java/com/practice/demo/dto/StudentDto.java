package com.practice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	protected String id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNo;
	
	private long dob;
	
	private int rollNo;
	
	private String department;
	
	private String year;
	
	private boolean married;
}
