package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserListResponseCreator {

	private PageResponseCreator pageResponseCreator;
	private Mapper<User, UserSummaryResponse> userSummaryResponseMapper;

	@Autowired
	public UserListResponseCreator(
		PageResponseCreator pageResponseCreator,
		Mapper<User, UserSummaryResponse> userSummaryResponseMapper
	) {
		this.pageResponseCreator = pageResponseCreator;
		this.userSummaryResponseMapper = userSummaryResponseMapper;
	}

	public UserListResponse create(Page<User> userPage) {

		List<UserSummaryResponse> users = new ArrayList<>();

		userPage.getContent().forEach(user -> {
			users.add(this.userSummaryResponseMapper.map(user));
		});

		return new UserListResponse()
			.setPage(this.pageResponseCreator.create(userPage))
			.setUsers(users);
	}

}
