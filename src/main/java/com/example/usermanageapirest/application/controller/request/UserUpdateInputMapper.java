package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.services.input.UserUpdateInput;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateInputMapper implements Mapper<UserUpdateRequest, UserUpdateInput> {

	@Override
	public UserUpdateInput map(UserUpdateRequest request) {
		return new UserUpdateInput()
			.setAge(request.getAge())
			.setLanguage(request.getLanguage())
			.setRank(request.getRank())
			.setCountry(request.getCountryId().getCountry().orElse(null))
			.setActive(request.isActive());
	}
}
