package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.builder.Builder;
import com.example.usermanageapirest.domain.entity.CountryBuilder;

public class UserUpdateInputBuilder extends Builder<UserUpdateInput> {

	@Override
	public UserUpdateInput build(int index) {
		return new UserUpdateInput()
			.setAge(50)
			.setLanguage("espannol")
			.setRank(index)
			.setCountry(new CountryBuilder().build(1))
			.setActive(true);
	}

}
