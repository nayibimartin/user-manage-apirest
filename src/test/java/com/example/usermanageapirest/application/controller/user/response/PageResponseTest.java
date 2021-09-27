package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PageResponseTest {

	@Test
	public void when_response_created_then_data_can_be_retrieved() {
		PageResponse actual= new PageResponse()
			.setPage(2)
			.setSize(10)
			.setTotalElements(20)
			.setTotalPages(2);

		assertEquals(2,actual.getPage());
		assertEquals(10,actual.getSize());
		assertEquals(20,actual.getTotalElements());
		assertEquals(2,actual.getTotalPages());
	}

}