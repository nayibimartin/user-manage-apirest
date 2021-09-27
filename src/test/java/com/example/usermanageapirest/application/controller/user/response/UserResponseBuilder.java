package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.builder.Builder;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserResponseBuilder extends Builder<UserResponse> {

	@Override
	public UserResponse build(int index) {
		return new UserResponse()
			.setFirstName("pepe"+index)
			.setLastName("martin"+index)
			.setAge(50+index)
			.setLanguage("espannol"+index)
			.setRank(1+index)
			.setCountryId(1+index)
			.setActive(true);
	}

}
