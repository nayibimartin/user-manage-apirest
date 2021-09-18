package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserUpdateInputTest {

	@Test
	public void when_object_is_created_then_data_can_be_retrieved() {
		UserUpdateInput actual = new UserUpdateInput()
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountry(new CountryBuilder().build(1))
			.setActive(true);

		assertEquals(50, actual.getAge());
		assertEquals("espannol", actual.getLanguage());
		assertEquals(1, actual.getRank());
		assertEquals(new CountryBuilder().build(1), actual.getCountry());
		assertTrue(actual.isActive());
	}

}