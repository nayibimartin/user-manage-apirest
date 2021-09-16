package com.example.usermanageapirest.application.controller.request;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import com.example.usermanageapirest.domain.services.input.UserUpdateInput;
import com.example.usermanageapirest.domain.services.input.UserUpdateInputBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserInfoUpdateInputCreatorTest {

	@InjectMocks
	private UserInfoUpdateInputCreator creator;

	@Mock
	private Mapper<UserUpdateRequest, UserUpdateInput> mapper;

	@Test
	public void when_creator_is_used_then_mapper_is_used() {
		this.creator.create(
			new UserBuilder().build(1), new UserUpdateRequestBuilder().build(1)
		);

		Mockito.verify(this.mapper).map(new UserUpdateRequestBuilder().build(1));
	}

	@Test
	public void when_data_is_mapped_then_input_is_created() {
		Mockito.when(this.mapper.map(any())).thenReturn(
			new UserUpdateInputBuilder().build(1)
		);

		UserInfoUpdateInput input = this.creator.create(
			new UserBuilder().build(1), new UserUpdateRequestBuilder().build(1)
		);

		assertEquals(new UserBuilder().build(1), input.getUser());
		assertEquals(new UserUpdateInputBuilder().build(1), input.getUserUpdateInput());
	}

}