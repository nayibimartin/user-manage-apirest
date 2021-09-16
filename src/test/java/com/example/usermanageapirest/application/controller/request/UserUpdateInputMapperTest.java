package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import com.example.usermanageapirest.domain.services.input.UserUpdateInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserUpdateInputMapperTest {

	@InjectMocks
	private UserUpdateInputMapper mapper;

	@Test
	public void when_data_is_mapped_then_input_is_returned() {
		UserUpdateInput actual = this.mapper.map(new UserUpdateRequestBuilder().build(1));

		assertEquals(50, actual.getAge());
		assertEquals("espannol", actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(new CountryBuilder().build(1), actual.getCountry());
		assertTrue(actual.isActive());
	}

}