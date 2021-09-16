package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.configuration.deserialize.CountryParameterBuilder;
import com.example.usermanageapirest.builder.Builder;

public class UserUpdateRequestBuilder extends Builder<UserUpdateRequest> {
	@Override
	public UserUpdateRequest build(int index) {
		return new UserUpdateRequest()
			.setAge(50)
			.setLanguage("espannol")
			.setRank(index)
			.setCountryId(new CountryParameterBuilder().build(index))
			.setActive(true);
	}
}
