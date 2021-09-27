package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.domain.entity.UniversityBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UniversityDetailsResponseMapperTest {

	@InjectMocks
	private UniversityDetailsResponseMapper mapper;

	@Test
	public void when_data_is_mapped_then_response_is_returned() {
		UniversityDetailsResponse actual = mapper.map(new UniversityBuilder().build(1));

		assertEquals("UCI1", actual.getName());
		assertEquals("informatics1", actual.getCareer());
	}
}