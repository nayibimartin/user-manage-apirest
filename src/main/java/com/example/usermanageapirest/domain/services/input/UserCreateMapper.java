package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper implements Mapper<UserCreateInput, User> {

	@Override
	public User map(UserCreateInput input) {
		return new User()
			.setFirstname(input.getFirstname())
			.setLastname(input.getLastname())
			.setAge(input.getAge())
			.setLanguage(input.getLanguage())
			.setRank(input.getRank())
			.setCountry(input.getCountry())
			.setActive(input.getActive());
	}
}
