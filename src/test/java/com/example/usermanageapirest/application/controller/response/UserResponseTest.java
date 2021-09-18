package com.example.usermanageapirest.application.controller.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserResponseTest {

	@Test
	public void when_request_is_created_then_data_can_be_retrieved() {
		UserResponse actual = new UserResponse()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountryId(1)
			.setActive(true);

		assertEquals("pepe", actual.getFirstName());
		assertEquals("martin", actual.getLastName());
		assertEquals(50, actual.getAge());
		assertEquals("espannol", actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(1, actual.getCountryId());
		assertTrue(actual.isActive());
	}

}