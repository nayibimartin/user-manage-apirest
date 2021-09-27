package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserSummaryResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		UserSummaryResponse actual= new UserSummaryResponse()
			.setUser(new UserDetailsResponseBuilder().build(1));

		assertEquals(new UserDetailsResponseBuilder().build(1), actual.getUser());
	}

}