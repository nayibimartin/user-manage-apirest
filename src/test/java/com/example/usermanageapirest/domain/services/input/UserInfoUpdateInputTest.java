package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserInfoUpdateInputTest {

	@Test
	public void when_object_is_created_then_data_can_be_retrieved() {
		UserInfoUpdateInput actual = new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1));

		assertEquals(new UserBuilder().build(1), actual.getUser());
		assertEquals(new UserUpdateInputBuilder().build(1), actual.getUserUpdateInput());
	}

}