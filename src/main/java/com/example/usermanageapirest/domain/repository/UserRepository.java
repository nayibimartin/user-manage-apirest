package com.example.usermanageapirest.domain.repository;

import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;

import java.util.Optional;

public interface UserRepository {

	User create(UserCreateInput user);

	Optional<User> find(Integer id);

	User update(UserInfoUpdateInput user);

	void delete(Integer userId);
}
