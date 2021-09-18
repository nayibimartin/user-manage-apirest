package com.example.usermanageapirest.domain.entity;

import com.example.usermanageapirest.builder.Builder;

public class UserBuilder extends Builder<User> {

	@Override
	public User build(int index) {
		return new User()
			.setId(index)
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountry(new CountryBuilder().build(index))
			.setActive(true);
	}

}
