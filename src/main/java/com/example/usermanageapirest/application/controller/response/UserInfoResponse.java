package com.example.usermanageapirest.application.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserInfoResponse {

	@JsonProperty("user")
	private final UserResponse userResponse;

}
