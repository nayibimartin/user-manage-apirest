package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.configuration.deserialize.CountryParameterBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserCreateRequestTest {

	@Test
	public void when_request_is_created_then_data_can_be_retrieved() {
		UserCreateRequest actual = new UserCreateRequest()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountryId(new CountryParameterBuilder().build(1))
			.setActive(true);

		assertEquals("pepe", actual.getFirstName());
		assertEquals("martin", actual.getLastName());
		assertEquals(50, actual.getAge());
		assertEquals("espannol", actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(new CountryParameterBuilder().build(1), actual.getCountryId());
		assertTrue(actual.isActive());
	}

}