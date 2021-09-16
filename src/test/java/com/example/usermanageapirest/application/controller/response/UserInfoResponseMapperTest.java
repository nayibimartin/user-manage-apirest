package com.example.usermanageapirest.application.controller.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserInfoResponseMapperTest {

	@InjectMocks
	private UserInfoResponseMapper userInfoResponseMapper;

	@Mock
	private Mapper<User, UserResponse> userResponseMapper;

	@Test
	public void when_mapper_is_used_then_user_response_is_mapped() {
		this.userInfoResponseMapper.map(new UserBuilder().build(1));

		Mockito.verify(this.userResponseMapper).map(new UserBuilder().build(1));
	}

	@Test
	public void when_user_response_is_mapped_then_response_is_return() {
		Mockito.when(this.userResponseMapper.map(any())).thenReturn(new UserResponseBuilder().build(1));

		UserInfoResponse actual = this.userInfoResponseMapper.map(
			new UserBuilder().build(1)
		);

		assertEquals(new UserInfoResponse(new UserResponseBuilder().build(1)), actual);
	}

}