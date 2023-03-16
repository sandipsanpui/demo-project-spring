package com.practice.demo.service.project;

import org.springframework.stereotype.Service;

import com.practice.demo.dto.UserEventDto;
import com.practice.demo.enums.UserEvent;
import com.practice.demo.service.factory.UserFactoryService;

@Service
public abstract class DashBoardService implements UserFactoryService {
	

	public UserEventDto getUserEventData() {
		UserEventDto userEveDto = new UserEventDto();
		userEveDto.setType(UserEvent.DASHBOARD);
		return userEveDto;
	}
}
