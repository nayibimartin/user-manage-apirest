package com.example.usermanageapirest.domain.services.validator;

import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.repository.CountryRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreateInputValidator {

	private CountryRepository repository;

	@Autowired
	public UserCreateInputValidator(CountryRepository repository) {
		this.repository = repository;
	}

	public void validateLanguage(UserCreateInput input) throws ValidationException {
		String languageCountry=this.repository.findLanguage(input.getCountry().getId());
		if(!(input.getLanguage().equals(languageCountry))){
			throw new ValidationException("INCOMPATIBLE_LANGUAGE","User language not compatible with country");
		}
	}
}
