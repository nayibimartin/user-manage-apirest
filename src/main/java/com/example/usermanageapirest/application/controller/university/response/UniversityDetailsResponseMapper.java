package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityDetailsResponseMapper implements Mapper<University, UniversityDetailsResponse> {

	@Override
	public UniversityDetailsResponse map(University input) {
		return new UniversityDetailsResponse()
			.setCareer(input.getCareer())
			.setName(input.getName());
	}

}
