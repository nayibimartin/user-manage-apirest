package com.example.usermanageapirest.infrastructure.postgresql;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserCreateInputBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserCreateMapperTest {

	@InjectMocks
	UserCreateMapper mapper;

	@Test
	public void when_data_is_mapped_then_input_is_returned() {
		User actual = mapper.map(new UserCreateInputBuilder().build(1));

		assertEquals("pepe", actual.getFirstName());
		assertEquals("martin", actual.getLastName());
		assertEquals(50, actual.getAge());
		assertEquals("espannol", actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(new CountryBuilder().build(1), actual.getCountry());
		assertTrue(actual.isActive());
	}

}