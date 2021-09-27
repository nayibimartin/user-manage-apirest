package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.University;
import com.example.usermanageapirest.domain.entity.UniversityBuilder;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversitiesResponseMapperTest {

	@InjectMocks
	UniversitiesResponseMapper responseMapper;

	@Mock
	Mapper<University, UniversityDetailsResponse> universityDetailsResponseMapper;

	@Test
	public void when_mapper_is_used_then_university_details_response_is_mapped() {
		this.responseMapper.map(new UniversityBuilder().build(1));

		verify(this.universityDetailsResponseMapper).map(new UniversityBuilder().build(1));
	}

	@Test
	public void when_university_details_response_is_mapped_then_response_is_return() {
		Mockito.when(this.universityDetailsResponseMapper.map(any())).thenReturn(new UniversityDetailsResponseBuilder().build(1));

		UniversityResponse actual = this.responseMapper.map(new UniversityBuilder().build(1));

		assertEquals(new UniversityResponseBuilder().build(1), actual);
	}

}