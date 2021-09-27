package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserResponseMapperTest {

	@InjectMocks
	private UserResponseMapper mapper;

	@Test
	public void when_data_is_mapped_then_response_is_returned() {
		UserResponse actual = this.mapper.map(new UserBuilder().build(1));

		assertEquals("pepe"+1, actual.getFirstName());
		assertEquals("martin"+1, actual.getLastName());
		assertEquals(50+1, actual.getAge());
		assertEquals("espannol"+1, actual.getLanguage());
		assertEquals(1+1, actual.getRank());
		assertEquals(new CountryBuilder().build(1).getId(), actual.getCountryId());
		assertTrue(actual.isActive());
	}

}