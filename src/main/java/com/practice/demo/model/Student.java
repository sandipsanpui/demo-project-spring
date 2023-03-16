package com.practice.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document
@NoArgsConstructor
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNo;
	
	private long dob;
	
	private int rollNo;
	
	private String department;
	
	private String year;
	
	private boolean married;

	public Student(String firstName, String lastName, String email, String phoneNo, Long dob, Integer rollNo,
			String department, String year, Boolean married) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.rollNo = rollNo;
		this.department = department;
		this.year = year;
		this.married = married;
	}
	
}
