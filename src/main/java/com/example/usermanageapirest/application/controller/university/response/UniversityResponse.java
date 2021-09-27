package com.example.usermanageapirest.application.controller.university.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UniversityResponse {

	@JsonProperty("university")
	private UniversityDetailsResponse universityDetailsResponse;

}
