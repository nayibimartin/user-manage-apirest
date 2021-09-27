package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserListResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		UserListResponse actual= new UserListResponse()
			.setPage(new PageResponseBuilder().build(1))
			.setUsers(new UserSummaryResponseBuilder().buildList(3));

		assertEquals(new PageResponseBuilder().build(1), actual.getPage());
		assertEquals(new UserSummaryResponseBuilder().buildList(3), actual.getUsers());
	}

}