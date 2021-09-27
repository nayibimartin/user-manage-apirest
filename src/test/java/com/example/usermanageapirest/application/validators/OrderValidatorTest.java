package com.example.usermanageapirest.application.validators;

import com.example.usermanageapirest.application.validator.OrderValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class OrderValidatorTest {

	@InjectMocks
	private OrderValidator orderValidatorToTest;

	@Test
	public void when_order_is_null_then_is_valid_should_be_false() {

		assertFalse(orderValidatorToTest.isValid(null));
	}

	@Test
	public void when_order_is_blank_then_is_valid_should_be_false() {

		assertFalse(orderValidatorToTest.isValid(" "));
	}

	@Test
	public void when_field_and_order_are_valid_then_is_valid_should_be_true() {

		assertTrue(orderValidatorToTest.isValid("name.asc"));
	}

	@Test
	public void when_field_is_invalid_then_is_valid_should_be_false() {

		assertFalse(orderValidatorToTest.isValid("foo.asc"));
	}

	@Test
	public void when_order_is_invalid_then_is_valid_should_be_false() {

		assertFalse(orderValidatorToTest.isValid("name.foo"));
	}

	@Test
	public void when_order_format_is_not_valid_is_valid_should_be_false() {

		assertFalse(orderValidatorToTest.isValid("name"));
		assertFalse(orderValidatorToTest.isValid("name."));
		assertFalse(orderValidatorToTest.isValid(".desc"));
		assertFalse(orderValidatorToTest.isValid("foo.foo.foo"));
	}
}