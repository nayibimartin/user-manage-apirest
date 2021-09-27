package com.example.usermanageapirest.application.controller.user.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PageResponseCreatorTest {

	@InjectMocks
	private PageResponseCreator creator;

	@Test
	public void when_create_is_used_then_response_is_returned() {
		PageResponse actual = this.creator.create(new PageBuilder().build(1));

		assertEquals(new PageResponseBuilder().build(1), actual);
	}

}