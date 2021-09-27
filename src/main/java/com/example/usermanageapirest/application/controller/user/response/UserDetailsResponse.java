package com.example.usermanageapirest.application.controller.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserDetailsResponse {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("age")
	private Integer age;

	@JsonProperty("countryId")
	private Integer countryId;

}
