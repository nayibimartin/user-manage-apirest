package com.example.usermanageapirest.application.controller.user.request;

import com.example.usermanageapirest.application.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class ParameterValueDecider {

	public <T> T decideValue(T originalValue, T defaultValue, Validator<T> validator) {
		return validator.isValid(originalValue) ? originalValue : defaultValue;
	}
}
