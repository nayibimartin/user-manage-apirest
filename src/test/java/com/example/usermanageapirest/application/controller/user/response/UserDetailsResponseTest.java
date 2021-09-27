package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserDetailsResponseTest {

	@Test
	public void when_response_created_then_data_can_be_retrieved() {
		UserDetailsResponse actual=new UserDetailsResponse()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(30)
			.setCountryId(1);

		assertEquals("pepe",actual.getFirstName());
		assertEquals("martin",actual.getLastName());
		assertEquals(30,actual.getAge());
		assertEquals(1,actual.getCountryId());
	}

}