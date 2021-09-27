package com.example.usermanageapirest.application.controller.user.request;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import com.example.usermanageapirest.domain.services.input.UserUpdateInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoUpdateInputCreator {

	private final Mapper<UserUpdateRequest, UserUpdateInput> userUpdateInputMapper;

	@Autowired
	public UserInfoUpdateInputCreator(Mapper<UserUpdateRequest, UserUpdateInput> userUpdateInputMapper) {
		this.userUpdateInputMapper = userUpdateInputMapper;
	}

	public UserInfoUpdateInput create(User user, UserUpdateRequest userUpdateRequest) {
		return new UserInfoUpdateInput()
			.setUser(user)
			.setUserUpdateInput(this.userUpdateInputMapper.map(userUpdateRequest));
	}
}
