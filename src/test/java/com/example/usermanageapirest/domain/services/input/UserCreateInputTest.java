package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.domain.entity.CountryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCreateInputTest {

	@Test
	public void when_object_is_created_then_data_can_be_retrieved(){
		UserCreateInput actual= new UserCreateInput()
			.setFirstName("pepe")
			.setLastName("martin")
			.setAge(50)
			.setLanguage("espannol")
			.setRank(1)
			.setCountry(new CountryBuilder().build(1))
			.setActive(true);

	}

}