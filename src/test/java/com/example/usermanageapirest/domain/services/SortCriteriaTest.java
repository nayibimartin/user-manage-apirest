package com.example.usermanageapirest.domain.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortCriteriaTest {

	@Test
	public void when_an_invalid_sort_criteria_is_given_then_is_sort_criteria_valid_should_be_false() {

		assertFalse(Sort.SortCriteria.isSortCriteriaValid("invalid-criteria"));
	}

	@Test
	public void when_a_valid_sort_criteria_is_given_then_is_sort_criteria_valid_should_be_true() {

		assertTrue(Sort.SortCriteria.isSortCriteriaValid("asc"));
	}

	@Test
	public void when_sort_criteria_is_asc_then_is_sort_criteria_asc_should_be_true() {

		Sort.SortCriteria actual = Sort.SortCriteria.ASC;

		assertTrue(actual.isSortCriteriaAsc());
	}

	@Test
	public void when_sort_criteria_is_not_asc_then_is_sort_criteria_asc_should_be_false() {

		Sort.SortCriteria actual = Sort.SortCriteria.DESC;

		assertFalse(actual.isSortCriteriaAsc());
	}

	@Test
	public void when_sort_criteria_is_desc_then_is_sort_criteria_desc_should_be_true() {

		Sort.SortCriteria actual = Sort.SortCriteria.DESC;

		assertTrue(actual.isSortCriteriaDesc());
	}

	@Test
	public void when_sort_criteria_is_not_desc_then_is_sort_criteria_desc_should_be_false() {

		Sort.SortCriteria actual = Sort.SortCriteria.ASC;

		assertFalse(actual.isSortCriteriaDesc());
	}
}
