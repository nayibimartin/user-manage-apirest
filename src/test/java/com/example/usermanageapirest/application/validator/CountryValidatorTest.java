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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class CountryValidatorTest {

	@InjectMocks
	private CountryValidator validator;

	@Mock
	private ConstraintValidatorContext context;

	@Test
	public void when_country_parameter_is_null_then_is_valid() {
		boolean actual = this.validator.isValid(null, this.context);

		assertTrue(actual);
	}

	@Test
	public void when_country_parameter_is_not_null_and_country_is_present_then_is_valid() {
		boolean actual = this.validator.isValid(
			new CountryParameterBuilder().build(1), this.context
		);

		assertTrue(actual);
	}

	@Test
	public void when_country_parameter_is_not_null_and_country_not_present_then_is_invalid() {
		boolean actual = this.validator.isValid(new CountryParameter(Optional.empty()), this.context);

		assertFalse(actual);
	}

}