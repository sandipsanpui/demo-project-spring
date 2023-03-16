package com.practice.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.model.Cause;
import com.practice.demo.model.CauseRepository;

@Service
public class TestService {
	
	private final CauseRepository causeRepository;
	
	@Autowired
	public TestService(CauseRepository causeRepository) {
		this.causeRepository = causeRepository;
	}
	
	public Cause getCause() {
		
		Optional<Cause> optionalCause = causeRepository.findById("62f5f0bc4b9ec60a5b0be00d");
		return optionalCause.get();
		
	}

}
