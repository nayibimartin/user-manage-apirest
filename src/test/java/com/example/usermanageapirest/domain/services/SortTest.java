package com.example.usermanageapirest.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortTest {

	@Test
	public void when_sort_is_created_values_are_correct() {

		Sort sort = new Sort(Sort.SortFields.FIRSTNAME, Sort.SortCriteria.ASC);
		Assertions.assertEquals(Sort.SortFields.LASTNAME, sort.getField());
		Assertions.assertEquals(Sort.SortCriteria.ASC, sort.getCriteria());
	}
}
