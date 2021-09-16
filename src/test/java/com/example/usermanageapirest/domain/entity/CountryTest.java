package com.example.usermanageapirest.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CountryTest {

	@Test
	public void when_values_are_given_then_they_can_be_retrieved() {
		Country actual = new Country()
			.setId(1)
			.setName("espanna")
			.setLanguage("espannol");

		assertEquals(1, actual.getId());
		assertEquals("espanna", actual.getName());
		assertEquals("espannol", actual.getLanguage());
	}

}