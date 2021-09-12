package com.example.usermanageapirest.application.configuration.deserialize;

import com.example.usermanageapirest.builder.Builder;
import com.example.usermanageapirest.domain.entity.CountryBuilder;

import java.util.Optional;

public class CountryParameterBuilder extends Builder<CountryParameter> {

	@Override
	public CountryParameter build(int index) {
		return new CountryParameter(Optional.of(new CountryBuilder().build(index)));
	}

}
