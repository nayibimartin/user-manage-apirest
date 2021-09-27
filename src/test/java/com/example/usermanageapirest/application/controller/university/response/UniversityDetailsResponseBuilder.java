package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.builder.Builder;

public class UniversityDetailsResponseBuilder extends Builder<UniversityDetailsResponse> {
	@Override
	public UniversityDetailsResponse build(int index) {
		return new UniversityDetailsResponse()
			.setCareer("informatics"+index)
			.setName("UCI"+index);
	}
}
