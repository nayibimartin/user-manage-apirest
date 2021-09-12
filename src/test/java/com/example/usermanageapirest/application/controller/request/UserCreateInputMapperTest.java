package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.configuration.deserialize.CountryParameterBuilder;
import com.example.usermanageapirest.domain.entity.CountryBuilder;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCreateInputMapperTest {

	@InjectMocks
	UserCreateInputMapper mapper;

	@Test
	public void when_data_is_mapped_then_input_is_returned(){
		UserCreateInput actual= mapper.map(new UserCreateRequestBuilder().build(1));

		assertEquals("pepe", actual.getFirstName());
		assertEquals("martin", actual.getLastName());
		assertEquals(50, actual.getAge());
		assertEquals("espannol",actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(new CountryBuilder().build(1), actual.getCountry());
		assertTrue(actual.isActive());
	}

}