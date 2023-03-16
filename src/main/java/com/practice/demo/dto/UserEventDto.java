package com.practice.demo.dto;

import com.practice.demo.enums.UserEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventDto {
	private UserEvent type;
}
