package com.example.usermanageapirest.domain.services.validator;

import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import org.springframework.stereotype.Component;

@Component
public class UserCreateInputValidator {

	public void validateLanguage(UserCreateInput input) throws ValidationException {
		if(!(input.getLanguage().equals(input.getCountry().getLanguage()))) {
			throw new ValidationException("INCOMPATIBLE_LANGUAGE", "User language not compatible with country");
		}
	}
}
