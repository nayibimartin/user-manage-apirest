package com.example.usermanageapirest.application.controller.user.response;

import static org.junit.jupiter.api.Assertions.*;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

@ExtendWith(MockitoExtension.class)
class UserListResponseCreatorTest {

	@InjectMocks
	private UserListResponseCreator creator;

	@Mock
	private PageResponseCreator pageResponseCreator;

	@Mock
	private Mapper<User, UserSummaryResponse> userSummaryResponseMapper;


	@Test
	public void when_create_is_used_then_mapper_is_used() {
		this.creator.create(new PageBuilder().build(3));

		Mockito.verify(this.userSummaryResponseMapper).map(new UserBuilder().build(0));
		Mockito.verify(this.userSummaryResponseMapper).map(new UserBuilder().build(1));
		Mockito.verify(this.userSummaryResponseMapper).map(new UserBuilder().build(1));
	}

	@Test
	public void when_create_is_used_then_page_creator_is_used() {
		Page<User> page= new PageBuilder().build(1);
		this.creator.create(page);

		Mockito.verify(this.pageResponseCreator).create(page);
	}

	@Test
	public void when_create_response_then_response_is_return() {
		Mockito.when(this.pageResponseCreator.create(ArgumentMatchers.any())).thenReturn(new PageResponseBuilder().build(1));
		Mockito.when(this.userSummaryResponseMapper.map(ArgumentMatchers.any())).thenReturn(new UserSummaryResponseBuilder().build(1));

		UserListResponse actual= this.creator.create(new PageBuilder().build(1));

		assertEquals(new PageResponseBuilder().build(1),actual.getPage());
		assertEquals(new UserSummaryResponseBuilder().buildList(1),actual.getUsers());

	}

}