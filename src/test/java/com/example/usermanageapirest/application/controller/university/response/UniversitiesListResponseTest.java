package com.example.usermanageapirest.application.controller.university.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversitiesListResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		UniversitiesListResponse actual=new UniversitiesListResponse()
			.setUniversities(new UniversityResponseBuilder().buildList(3));

		assertEquals(new UniversityResponseBuilder().buildList(3),actual.getUniversities());
	}
}