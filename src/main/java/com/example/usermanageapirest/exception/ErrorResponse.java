package com.example.usermanageapirest.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {

	private String code;
	private String message;
	private List<ErrorDetails> details = new ArrayList<>();

	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public void addDetail(String value, String message) {
		this.details.add(new ErrorDetails(value, message));
	}

}
