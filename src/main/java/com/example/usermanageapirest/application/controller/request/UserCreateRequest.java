package com.example.usermanageapirest.application.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Schema(name = "CreateUserRequest", required = true)
public class UserCreateRequest {

	@JsonProperty("firstName")
	@Schema(required = true, description ="User's first name. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private String firstName;

	@JsonProperty("lastName")
	@Schema(required = true, description ="User's last name. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private String lastName;

	@JsonProperty("age")
	@Schema(required = true, description ="User's age. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private int age;

	@JsonProperty("language")
	@Schema(required = true, description ="User's language. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private String language;

	@JsonProperty("rank")
	@Schema(required = true, description ="User's rank. Validation errors: REQUIRED, RANK_ZERO_OR_GREATER, RANK_ZERO_OR_GREATER")
	@NotNull(message = "REQUIRED")
	@Min(value = 0, message = "RANK_ZERO_OR_GREATER")
	@Max(value = 5, message = "RANK_FIVE_OR_LOWER")
	private int rank;

	@JsonProperty("country")
	@Schema(required = true, description ="User's country. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private String country;

	@JsonProperty("active")
	@Schema(required = true, description ="Flag to indicate if user is active or not. Validation errors: REQUIRED")
	@NotNull(message = "REQUIRED")
	private String active;

}
