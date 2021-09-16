package com.example.usermanageapirest.domain.services.validator;

import com.example.usermanageapirest.domain.entity.Country;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import org.springframework.stereotype.Component;

@Component
public class UserInputValidator {

	public void validateUserCreateInput(UserCreateInput input) throws ValidationException {
		this.validateLanguage(input.getCountry(), input.getLanguage());
	}

	public void validateUserInfoUpdateInput(UserInfoUpdateInput input) throws ValidationException {
		this.validateLanguage(input.getUserUpdateInput().getCountry(), input.getUserUpdateInput().getLanguage());
	}

	public void validateLanguage(Country country, String language) throws ValidationException {
		if(!(language.equals(country.getLanguage()))) {
			throw new ValidationException("INCOMPATIBLE_LANGUAGE", "User language not compatible with country");
		}
	}
}
