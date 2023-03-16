package com.practice.demo.service;

import org.springframework.stereotype.Service;

import com.practice.demo.dto.UserEventDto;
import com.practice.demo.enums.UserEvent;
import com.practice.demo.service.factory.UserFactory;

@Service
public class UserEventService {
	
	public UserEventDto getUserEvent(UserEvent type) {
		return UserFactory.getService(type);
	}	
}
