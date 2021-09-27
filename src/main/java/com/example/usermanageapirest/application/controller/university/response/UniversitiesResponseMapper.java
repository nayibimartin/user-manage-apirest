package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversitiesResponseMapper implements Mapper<University, UniversityResponse> {

	private Mapper<University, UniversityDetailsResponse> universityDetailsResponseMapper;

	@Autowired
	public UniversitiesResponseMapper(Mapper<University, UniversityDetailsResponse> universityDetailsResponseMapper) {
		this.universityDetailsResponseMapper = universityDetailsResponseMapper;
	}

	@Override
	public UniversityResponse map(University input) {
		return new UniversityResponse()
			.setUniversityDetailsResponse(this.universityDetailsResponseMapper.map(input));
	}
}
