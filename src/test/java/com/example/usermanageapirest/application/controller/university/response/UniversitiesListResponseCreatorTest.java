package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.University;
import com.example.usermanageapirest.domain.entity.UniversityBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UniversitiesListResponseCreatorTest {

	@InjectMocks
	private UniversitiesListResponseCreator creator;

	@Mock
	private Mapper<University, UniversityResponse> universitiesResponseMapper;

	@Test
	public void when_create_is_used_then_university_list_is_mapped() {
		this.creator.create(new UniversityBuilder().buildList(3));

		verify(this.universitiesResponseMapper).map(new UniversityBuilder().build(0));
		verify(this.universitiesResponseMapper).map(new UniversityBuilder().build(1));
		verify(this.universitiesResponseMapper).map(new UniversityBuilder().build(2));
	}

	@Test
	public void when_university_list_is_mapped_then_list_response_is_return() {
		when(this.universitiesResponseMapper.map(new UniversityBuilder().build(0))).thenReturn(new UniversityResponseBuilder().build(
			0));
		when(this.universitiesResponseMapper.map(new UniversityBuilder().build(1))).thenReturn(new UniversityResponseBuilder().build(
			1));
		when(this.universitiesResponseMapper.map(new UniversityBuilder().build(2))).thenReturn(new UniversityResponseBuilder().build(
			2));

		UniversitiesListResponse actual = this.creator.create(new UniversityBuilder().buildList(3));

		Assertions.assertEquals(new UniversitiesListResponse().setUniversities(new UniversityResponseBuilder().buildList(3)),
			actual);

	}
}