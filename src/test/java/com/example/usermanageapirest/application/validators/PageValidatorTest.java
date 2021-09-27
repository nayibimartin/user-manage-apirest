package com.example.usermanageapirest.application.validators;

import com.example.usermanageapirest.application.validator.PageValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PageValidatorTest {

	@InjectMocks
	private PageValidator pageValidatorToTest;

	@Test
	public void when_page_is_null_then_is_valid_should_be_false() {

		assertFalse(pageValidatorToTest.isValid(null));
	}

	@Test
	public void when_page_is_less_than_zero_then_is_valid_should_be_false() {

		assertFalse(pageValidatorToTest.isValid(-1));
	}

	@Test
	public void when_page_is_greater_or_equal_to_zero_then_is_valid_should_be_true() {

		assertTrue(pageValidatorToTest.isValid(0));
	}
}
