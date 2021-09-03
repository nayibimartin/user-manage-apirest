package com.example.usermanageapirest.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ValidationException extends Exception{

	private final String value;

	private final String message;

}
