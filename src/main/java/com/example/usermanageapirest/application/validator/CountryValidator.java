package com.example.usermanageapirest.application.validator;

import com.example.usermanageapirest.application.configuration.deserialize.CountryParameter;
import com.example.usermanageapirest.application.validator.annotations.Country;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class CountryValidator implements ConstraintValidator<Country, CountryParameter> {

	@Override
	public boolean isValid(CountryParameter value, ConstraintValidatorContext context) {
		return Objects.isNull(value) || value.getCountry().isPresent();
	}

}
