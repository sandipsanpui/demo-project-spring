package com.practice.demo.service.exception;

public class UserFactoryNotSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserFactoryNotSupportedException(String type) {
		super("User factory : " + type + " does not supported");
	}
}
