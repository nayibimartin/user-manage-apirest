package com.example.usermanageapirest.application.configuration.deserialize;

import com.example.usermanageapirest.domain.repository.CountryRepository;
import com.example.usermanageapirest.exception.ValueDeserializationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class CountryDeserializer extends JsonDeserializer<CountryParameter> {

	private final CountryRepository repository;

	@Autowired
	public CountryDeserializer(CountryRepository repository) {
		this.repository = repository;
	}

	@Override
	public CountryParameter deserialize(
		JsonParser jsonParser, DeserializationContext deserializationContext
	) throws IOException, JsonProcessingException {
		int id;
		try{
			id=jsonParser.getIntValue();
		}catch(Exception e){
			throw new ValueDeserializationException("INVALID_COUNTRY");
		}
		return new CountryParameter(this.repository.find(id));
	}
}
