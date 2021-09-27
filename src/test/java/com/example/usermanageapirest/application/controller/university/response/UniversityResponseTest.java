package com.example.usermanageapirest.application.controller.university.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UniversityResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		UniversityResponse actual = new UniversityResponse()
			.setUniversityDetailsResponse(new UniversityDetailsResponseBuilder().build(1));

		assertEquals(new UniversityDetailsResponseBuilder().build(1), actual.getUniversityDetailsResponse());
	}

}