package com.example.usermanageapirest.application.validator;

public interface Validator<T> {

	boolean isValid(T parameter);
}
