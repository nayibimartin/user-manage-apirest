package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.builder.Builder;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsResponseBuilder extends Builder<UserDetailsResponse> {

	@Override
	public UserDetailsResponse build(int index) {
		return new UserDetailsResponse()
			.setFirstName("pepe"+index)
			.setLastName("martin"+index)
			.setAge(50+index)
			.setCountryId(1+index);
	}
}