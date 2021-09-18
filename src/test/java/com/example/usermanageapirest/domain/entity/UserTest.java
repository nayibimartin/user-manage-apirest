package com.example.usermanageapirest.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserTest {

	@Test
	public void when_values_are_given_then_they_can_be_retrieved() {
		User actual = new User()
			.setId(1)
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountry(new CountryBuilder().build(1))
			.setActive(true);

		assertEquals(1, actual.getId());
		assertEquals("pepe", actual.getFirstName());
		assertEquals("martin", actual.getLastName());
		assertEquals(50, actual.getAge());
		assertEquals("espannol", actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(new CountryBuilder().build(1), actual.getCountry());
		assertTrue(actual.isActive());
	}

}