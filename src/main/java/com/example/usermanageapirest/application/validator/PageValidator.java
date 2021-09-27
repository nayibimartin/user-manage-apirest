package com.example.usermanageapirest.application.validator;

import org.springframework.stereotype.Component;

@Component
public class PageValidator implements Validator<Integer> {

	@Override
	public boolean isValid(Integer page) {
		return page == null || page < 0;
	}
}
