package com.example.usermanageapirest.domain.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortFieldsTest {

	@Test
	public void when_an_invalid_sort_field_is_given_then_is_sort_valid_field_should_be_false() {

		assertFalse(Sort.SortFields.isSortFieldValid("invalid-field"));
	}

	@Test
	public void when_a_valid_sort_field_is_given_then_is_sort_valid_field_should_be_true() {

		assertTrue(Sort.SortFields.isSortFieldValid("id"));
	}
}
