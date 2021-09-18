package com.example.usermanageapirest.application.controller.response;

import com.example.usermanageapirest.builder.Builder;

public class UserResponseBuilder extends Builder<UserResponse> {

	@Override
	public UserResponse build(int index) {
		return new UserResponse()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountryId(1)
			.setActive(true);
	}

}
