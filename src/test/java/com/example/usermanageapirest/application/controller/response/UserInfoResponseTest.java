package com.example.usermanageapirest.application.controller.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserInfoResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		UserInfoResponse actual = new UserInfoResponse(new UserResponseBuilder().build(1));

		assertEquals(new UserResponseBuilder().build(1), actual.getUserResponse());
	}

}