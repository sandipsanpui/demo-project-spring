package com.practice.demo.enums;

import java.util.HashMap;
import java.util.Map;

import com.practice.demo.service.exception.InvalidTypeException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEvent {
	DASHBOARD("DASHBOARD"), EMAIL("EMAIL"), MESSAGE("MESSAGE"), PUSH_NOTIFICATION("PUSH_NOTIFICATION");

	@Getter
	private final String userEventType;

	private static final Map<String, UserEvent> map;

	static {
		map = new HashMap<>();
		for (UserEvent type : UserEvent.values()) {
			map.put(type.getUserEventType().toLowerCase(), type);
		}
	}

	static public boolean isValid(String notificationType) throws InvalidTypeException {
		if (!map.containsKey(notificationType.toLowerCase())) {
			throw new InvalidTypeException(notificationType);
		}
		return map.containsKey(notificationType.toLowerCase());
	}

	public static UserEvent getValue(String type) {
		return map.get(type.toLowerCase());
	}
}
