package com.example.usermanageapirest.application.validators;

import com.example.usermanageapirest.application.controller.user.request.ParameterValueDecider;
import com.example.usermanageapirest.application.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParameterValueDeciderTest {

	@Mock
	private Validator<String> validator;

	@InjectMocks
	private ParameterValueDecider parameterValueDeciderToTest;

	@Test
	public void when_parameter_validator_is_false_then_default_value_should_be_returned() {

		when(validator.isValid("originalValue")).thenReturn(false);

		String decidedValue = parameterValueDeciderToTest.decideValue("originalValue",
			"defaultValue", validator
		);

		Assertions.assertEquals("defaultValue", decidedValue);
	}

	@Test
	public void when_parameter_validator_is_true_then_original_value_should_be_returned() {

		when(validator.isValid("originalValue")).thenReturn(true);

		String decidedValue = parameterValueDeciderToTest.decideValue("originalValue",
			"defaultValue", validator
		);

		Assertions.assertEquals("originalValue", decidedValue);
	}
}
