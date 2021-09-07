package com.example.usermanageapirest.infrastructure.postgresql;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper implements Mapper<UserCreateInput, User> {

	@Override
	public User map(UserCreateInput input) {
		return new User()
			.setFirstName(input.getFirstName())
			.setLastName(input.getLastName())
			.setAge(input.getAge())
			.setLanguage(input.getLanguage())
			.setRank(input.getRank())
			.setCountry(input.getCountry())
			.setActive(input.isActive());
	}

}
