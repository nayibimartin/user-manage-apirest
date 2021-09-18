package com.example.usermanageapirest.domain.exception;

public class ResourceDeleteException extends RuntimeException {

	public ResourceDeleteException(Throwable cause) {
		super(cause);
	}

	public ResourceDeleteException(String message) {
		super(message);
	}

}
