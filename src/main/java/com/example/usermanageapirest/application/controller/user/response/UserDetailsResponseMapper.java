package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsResponseMapper implements Mapper<User, UserDetailsResponse> {

	@Override
	public UserDetailsResponse map(User input) {
		return new UserDetailsResponse()
			.setFirstName(input.getFirstName())
			.setLastName(input.getLastName())
			.setAge(input.getAge())
			.setCountryId(input.getCountry().getId());
	}
}
