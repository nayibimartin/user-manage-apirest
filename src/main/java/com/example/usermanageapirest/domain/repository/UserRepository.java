package com.example.usermanageapirest.domain.repository;

import com.example.usermanageapirest.application.controller.response.UserInfoResponse;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface UserRepository {

	User create(UserCreateInput user);

	Optional<User> find(Integer id);

	User update(UserInfoUpdateInput user);

	Optional<User> get(Integer userId);

}
