package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.configuration.deserialize.CountryParameterBuilder;
import com.example.usermanageapirest.builder.Builder;

public class UserCreateRequestBuilder extends Builder<UserCreateRequest> {

	@Override
	public UserCreateRequest build(int index) {
		return new UserCreateRequest()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(index)
			.setCountryId(new CountryParameterBuilder().build(index))
			.setActive(true);
	}
}
