package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserSummaryResponseMapperTest {

	@InjectMocks
	private UserSummaryResponseMapper mapper;

	@Mock
	private Mapper<User, UserDetailsResponse> userDetailsResponseMapper;

	@Test
	public void when_mapper_is_used_then_details_response_is_mapped(){
		this.mapper.map(new UserBuilder().build(1));

		verify(this.userDetailsResponseMapper).map(new UserBuilder().build(1));
	}

	@Test
	public void when_details_response_is_mapped_then_response_is_return() {
		when(this.userDetailsResponseMapper.map(any())).thenReturn(new UserDetailsResponseBuilder().build(1));

		UserSummaryResponse actual= this.mapper.map(new UserBuilder().build(1));

		assertEquals(new UserSummaryResponseBuilder().build(1),actual);
	}



}