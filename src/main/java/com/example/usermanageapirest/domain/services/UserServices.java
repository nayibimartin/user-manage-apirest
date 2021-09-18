package com.example.usermanageapirest.domain.services;

import com.example.usermanageapirest.application.controller.response.UniversitiesListResponse;
import com.example.usermanageapirest.application.controller.response.UniversityInfoResponse;
import com.example.usermanageapirest.application.controller.response.UserInfoResponse;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.domain.exception.ResourceUpdateException;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.repository.UserRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import com.example.usermanageapirest.domain.services.validator.UserInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	private final UserRepository userRepository;
	private final UserInputValidator validator;

	@Autowired
	public UserServices(
		UserRepository userRepository,
		UserInputValidator validator
	) {
		this.validator = validator;
		this.userRepository = userRepository;
	}

	public User create(UserCreateInput input) throws ResourceCreateException, ValidationException {
		this.validator.validateUserCreateInput(input);
		return this.userRepository.create(input);
	}

	public User update(UserInfoUpdateInput input) throws ResourceUpdateException, ValidationException {
		this.validator.validateUserInfoUpdateInput(input);
		return this.userRepository.update(input);
		userValidator.validateLanguage(input);
		return this.userRepository.create(input);
	}

	public User get(Integer userId) {
		return this.userRepository.get(userId).get();
	}

	public ResponseEntity<UniversitiesListResponse> listUniversities(User userId) {
		return null;
	}

	public ResponseEntity<UniversityInfoResponse> getUniversity(User userId, Integer universityId) {
		return null;
	}
}
