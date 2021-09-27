package com.example.usermanageapirest.application.validator;

import org.springframework.stereotype.Component;

@Component
public class SizeValidator implements Validator<Integer> {

	@Override
	public boolean isValid(Integer size) {
		return size == null || size < 1 ;
	}
}
