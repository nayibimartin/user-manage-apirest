package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.builder.Builder;
import com.example.usermanageapirest.domain.entity.CountryBuilder;

public class UserCreateInputBuilder extends Builder<UserCreateInput> {

	@Override
	public UserCreateInput build(int index) {
		return new UserCreateInput()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(index)
			.setCountry(new CountryBuilder().build(index))
			.setActive(true);
	}

}
