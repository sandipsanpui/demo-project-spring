package com.practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.model.Cause;
import com.practice.demo.service.TestService;

@RestController
@RequestMapping("/test")
public class TestingController {
	
	private TestService testService;
	
	@Autowired
	public TestingController(TestService testService) {
		this.testService = testService;
		
	}
	
	
	@GetMapping("/data")
	public ResponseEntity<Cause> getTestData() {
				return ResponseEntity.status(HttpStatus.OK)
		                .body(testService.getCause());
	}

}
