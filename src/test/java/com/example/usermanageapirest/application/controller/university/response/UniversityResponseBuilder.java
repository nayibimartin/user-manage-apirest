package com.example.usermanageapirest.application.controller.university.response;

import com.example.usermanageapirest.builder.Builder;

public class UniversityResponseBuilder extends Builder<UniversityResponse> {
	@Override
	public UniversityResponse build(int index) {
		return new UniversityResponse()
			.setUniversityDetailsResponse(new UniversityDetailsResponseBuilder().build(index));
	}
}
