package com.example.usermanageapirest.application.validators;

import com.example.usermanageapirest.application.validator.SizeValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SizeValidatorTest {

	@InjectMocks
	private SizeValidator sizeValidatorToTest;

	@Test
	public void when_size_is_null_then_is_valid_should_be_false() {

		assertFalse(sizeValidatorToTest.isValid(null));
	}

	@Test
	public void when_size_is_size_is_less_than_one_then_is_valid_should_be_false() {

		assertFalse(sizeValidatorToTest.isValid(0));
	}

	@Test
	void when_size_is_greater_or_equal_to_one_then_is_valid_should_be_true() {

		assertTrue(sizeValidatorToTest.isValid(1));
	}
}
