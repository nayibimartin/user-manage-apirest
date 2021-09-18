package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.configuration.deserialize.CountryDeserializer;
import com.example.usermanageapirest.application.configuration.deserialize.CountryParameter;
import com.example.usermanageapirest.application.validator.annotations.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Schema(name = "UserUpdateRequest", required = true)
public class UserUpdateRequest {

	@JsonProperty("age")
	@Schema(required = true, description = "User's age. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private Integer age;

	@JsonProperty("language")
	@Schema(required = true, description = "User's language. Validation errors: REQUIRED")
	@NotBlank(message = "REQUIRED")
	private String language;

	@JsonProperty("rank")
	@Schema(required = true, description = "User's rank. Validation errors: REQUIRED, RANK_ZERO_OR_GREATER, RANK_ZERO_OR_GREATER")
	@NotNull(message = "REQUIRED")
	@Min(value = 0, message = "RANK_ZERO_OR_GREATER")
	@Max(value = 5, message = "RANK_FIVE_OR_LOWER")
	private Integer rank;

	@JsonProperty("countryId")
	@Schema(required = true, description = "User's country. Validation errors: REQUIRED")
	@JsonDeserialize(using = CountryDeserializer.class)
	@NotNull(message = "REQUIRED")
	@Country(message = "NOT_EXISTS")
	private CountryParameter countryId;

	@JsonProperty("active")
	@Schema(required = true, description = "Flag to indicate if user is active or not. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private boolean active;

}
