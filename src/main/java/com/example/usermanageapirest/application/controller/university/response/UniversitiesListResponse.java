package com.example.usermanageapirest.application.controller.university.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Data
public class UniversitiesListResponse {

	@JsonProperty("universities")
	private List<UniversityResponse> universities = new ArrayList<>();

}
