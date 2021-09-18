package com.example.usermanageapirest.application.exception;

public class EndpointArgumentException extends RuntimeException {

	public EndpointArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

}
