package com.example.usermanageapirest.application.controller.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class UserListResponse {

	@JsonProperty("page")
	private PageResponse page;

	@JsonProperty("users")
	private List<UserSummaryResponse> users;

}
