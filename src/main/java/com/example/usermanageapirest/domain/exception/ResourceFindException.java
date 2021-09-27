package com.example.usermanageapirest.domain.exception;

public class ResourceFindException extends RuntimeException {

	public ResourceFindException(Throwable cause) {
		super(cause);
	}

	public ResourceFindException(String message) {
		super(message);
	}
}
