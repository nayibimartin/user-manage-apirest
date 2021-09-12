package com.example.usermanageapirest.domain.repository;

import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;

public interface UserRepository {

	User create(UserCreateInput user);

}
