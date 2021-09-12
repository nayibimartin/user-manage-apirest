package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.application.validator.annotations.Country;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import org.springframework.stereotype.Component;

@Component
public class UserCreateInputMapper implements Mapper<UserCreateRequest, UserCreateInput> {

	@Override
	public UserCreateInput map(UserCreateRequest request) {
		return new UserCreateInput()
			.setFirstName(request.getFirstName())
			.setLastName(request.getLastName())
			.setAge(request.getAge())
			.setLanguage(request.getLanguage())
			.setRank(request.getRank())
			.setCountry(request.getCountryId().getCountry().orElse(null))
			.setActive(request.isActive());
	}

}
