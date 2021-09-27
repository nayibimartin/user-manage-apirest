package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserDetailsResponseMapperTest {

	@InjectMocks
	private UserDetailsResponseMapper mapper;

	@Test
	public void when_data_is_mapped_then_response_is_returned() {
		UserDetailsResponse actual = this.mapper.map(new UserBuilder().build(1));

		assertEquals("pepe"+1,actual.getFirstName());
		assertEquals("martin"+1,actual.getLastName());
		assertEquals(50+1,actual.getAge());
		assertEquals(1,actual.getCountryId());
	}

}