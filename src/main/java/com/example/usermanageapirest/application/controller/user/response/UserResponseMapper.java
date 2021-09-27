package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<User, UserResponse> {

	@Override
	public UserResponse map(User user) {
		return new UserResponse()
			.setFirstName(user.getFirstName())
			.setLastName(user.getLastName())
			.setAge(user.getAge())
			.setLanguage(user.getLanguage())
			.setRank(user.getRank())
			.setCountryId(user.getCountry().getId())
			.setActive(user.isActive());
	}
}
