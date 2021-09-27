package com.example.usermanageapirest.application.controller.university.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UniversityDetailsResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		UniversityDetailsResponse actual = new UniversityDetailsResponse()
			.setCareer("informatics")
			.setName("UCI");

		assertEquals("informatics", actual.getCareer());
		assertEquals("UCI", actual.getName());
	}

}