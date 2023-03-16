package com.practice.demo.service.exception;

public class StudentNotFoundException extends Exception {
	public StudentNotFoundException(String id) {
		super("Student not found for this " + id);
	}
}
