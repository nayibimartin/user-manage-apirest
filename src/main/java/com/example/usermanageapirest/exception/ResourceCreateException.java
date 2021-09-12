package com.example.usermanageapirest.exception;

public class ResourceCreateException extends RuntimeException{

	public ResourceCreateException(Throwable cause) {
		super(cause);
	}

	public ResourceCreateException(String message) {
		super(message);
	}

}
