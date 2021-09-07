package com.example.usermanageapirest.application.validator;

import com.example.usermanageapirest.application.configuration.deserialize.CountryParameter;
import com.example.usermanageapirest.application.configuration.deserialize.CountryParameterBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountryValidatorTest {

	@InjectMocks
	CountryValidator validator;

	@Mock
	ConstraintValidatorContext context;

	@Test
	public void when_country_parameter_is_null_then_is_valid(){
		boolean actual=validator.isValid(null,this.context);

		assertTrue(actual);
	}

	@Test
	public void when_country_parameter_is_not_null_and_country_is_present_then_is_valid(){
		boolean actual=validator.isValid(new CountryParameterBuilder().build(1), context);

		assertTrue(actual);
	}

	@Test
	public void when_country_parameter_is_not_null_and_country_not_present_then_is_invalid(){
		boolean actual=validator.isValid(new CountryParameter(Optional.empty()),context);

		assertFalse(actual);
	}


}