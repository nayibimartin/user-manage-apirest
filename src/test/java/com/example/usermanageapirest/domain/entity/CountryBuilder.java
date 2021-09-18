package com.example.usermanageapirest.domain.entity;

import com.example.usermanageapirest.builder.Builder;

public class CountryBuilder extends Builder<Country> {

	@Override
	public Country build(int index) {
		return new Country()
			.setId(index)
			.setName("espanna")
			.setLanguage("espannol");
	}

}
