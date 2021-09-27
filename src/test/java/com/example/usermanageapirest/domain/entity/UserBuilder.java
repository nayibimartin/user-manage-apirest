package com.example.usermanageapirest.domain.entity;

import com.example.usermanageapirest.builder.Builder;

public class UserBuilder extends Builder<User> {

	@Override
	public User build(int index) {
		return new User()
			.setId(index)
			.setFirstName("pepe"+index)
			.setLastName("martin"+index)
			.setAge(50+index)
			.setLanguage("espannol"+index)
			.setRank(1+index)
			.setCountry(new CountryBuilder().build(index))
			.setActive(true)
			.setUniversities(new UniversityBuilder().buildList(2));

	}

}
