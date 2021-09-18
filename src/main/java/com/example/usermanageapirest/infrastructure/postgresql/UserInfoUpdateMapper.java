package com.example.usermanageapirest.infrastructure.postgresql;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import org.springframework.stereotype.Component;

@Component
public class UserInfoUpdateMapper implements Mapper<UserInfoUpdateInput, User> {

	@Override
	public User map(UserInfoUpdateInput input) {
		return input.getUser()
			.setLanguage(input.getUserUpdateInput().getLanguage())
			.setActive(input.getUserUpdateInput().isActive())
			.setAge(input.getUserUpdateInput().getAge())
			.setRank(input.getUserUpdateInput().getRank())
			.setCountry(input.getUserUpdateInput().getCountry());
	}

}
