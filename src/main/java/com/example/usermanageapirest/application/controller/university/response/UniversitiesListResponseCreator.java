package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversitiesListResponseCreator {

	private Mapper<University, UniversityResponse> universitiesResponseMapper;

	@Autowired
	public UniversitiesListResponseCreator(Mapper<University, UniversityResponse> universitiesResponseMapper) {
		this.universitiesResponseMapper = universitiesResponseMapper;
	}

	public UniversitiesListResponse create(List<University> input) {
		UniversitiesListResponse universities = new UniversitiesListResponse();

		input.forEach(university ->
			universities.getUniversities().add(universitiesResponseMapper.map(university)));

		return universities;
	}
}
