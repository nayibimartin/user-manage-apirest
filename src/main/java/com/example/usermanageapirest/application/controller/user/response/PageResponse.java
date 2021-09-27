package com.example.usermanageapirest.application.controller.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class PageResponse {

	@JsonProperty("page")
	private Integer page;

	@JsonProperty("size")
	private Integer size;

	@JsonProperty("totalElements")
	private Integer totalElements;

	@JsonProperty("totalPages")
	private Integer totalPages;

}
