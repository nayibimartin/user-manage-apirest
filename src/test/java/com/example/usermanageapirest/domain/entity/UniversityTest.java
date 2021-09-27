package com.example.usermanageapirest.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversityTest {

	@Test
	public void when_values_are_given_then_they_can_be_retrieved() {
		University actual= new University()
			.setId(1)
			.setCareer("informatics")
			.setName("UCI");

		assertEquals(1,actual.getId());
		assertEquals("informatics",actual.getCareer());
		assertEquals("UCI",actual.getName());
	}

}