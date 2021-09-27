package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoResponseMapper implements Mapper<User, UserInfoResponse> {

	private final Mapper<User, UserResponse> userResponseMapper;

	@Autowired
	public UserInfoResponseMapper(Mapper<User, UserResponse> userResponseMapper) {
		this.userResponseMapper = userResponseMapper;
	}

	@Override
	public UserInfoResponse map(User user) {
		return new UserInfoResponse(this.userResponseMapper.map(user));
	}
}
