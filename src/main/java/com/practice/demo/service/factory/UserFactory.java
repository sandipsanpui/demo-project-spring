package com.practice.demo.service.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.enums.UserEvent;
import com.practice.demo.service.exception.UserFactoryNotSupportedException;

import jakarta.annotation.PostConstruct;

@Service
public class UserFactory {
	private List<UserFactoryService> userFactoryService;

	private static final Map<UserEvent, UserFactoryService> userFactoryServiceCache = new HashMap<>();

	@Autowired
	public UserFactory(List<UserFactoryService> userFactoryService) {
		this.userFactoryService = userFactoryService;
	}

	@PostConstruct
	public void initUserCustomNotificationCache() {
		for (UserFactoryService service : userFactoryService) {
			userFactoryServiceCache.put(service.getType(), service);
		}
	}

	public static UserFactoryService getService(UserEvent type) throws UserFactoryNotSupportedException {
		UserFactoryService service = userFactoryServiceCache.get(type);
		if (service == null) {
			throw new UserFactoryNotSupportedException(type.toString());
		}
		return service;
	}
}
