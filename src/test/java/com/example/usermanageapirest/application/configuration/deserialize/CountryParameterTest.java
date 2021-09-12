package com.example.usermanageapirest.application.configuration.deserialize;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountryParameterTest {

	@Test
	public void when_object_is_created_then_data_can_be_retrieved(){
		CountryParameter actual=new CountryParameter(Optional.of(new CountryBuilder().build(1)));

		assertTrue(actual.getCountry().isPresent());
		assertEquals(new CountryBuilder().build(1), actual.getCountry().get());
	}

}