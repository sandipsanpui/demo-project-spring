package com.practice.demo.service.exception;

public class InvalidTypeException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidTypeException(String type) {
		super("User Event :" + type + " does not exist");
	}
}
