package com.example.usermanageapirest.domain.services;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.repository.UserRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.validator.UserCreateInputValidator;
import com.example.usermanageapirest.exception.ResourceCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	private final UserRepository userRepository;
	private final UserCreateInputValidator userValidator;
	private final Mapper<UserCreateInput, User> userMapper;

	@Autowired
	public UserServices(
		UserRepository userRepository,
		UserCreateInputValidator userValidator,
		Mapper<UserCreateInput, User> userMapper
	) {
		this.userValidator = userValidator;
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public User create(UserCreateInput input) throws ResourceCreateException, ValidationException {
		userValidator.validateLanguage(input);
		return userRepository.create(input);
	}

}
