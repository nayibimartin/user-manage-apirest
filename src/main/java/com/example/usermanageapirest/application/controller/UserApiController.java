package com.example.usermanageapirest.application.controller;

import com.example.usermanageapirest.application.controller.request.UserCreateRequest;
import com.example.usermanageapirest.application.controller.request.UserInfoUpdateInputCreator;
import com.example.usermanageapirest.application.controller.request.UserUpdateRequest;
import com.example.usermanageapirest.application.controller.response.UserInfoResponse;
import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.services.UserServices;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserApiController implements UsersApi {

	private final UserServices userServices;
	private final Mapper<UserCreateRequest, UserCreateInput> userCreateMapper;
	private final UserInfoUpdateInputCreator userInfoUpdateInputCreator;
	private final Mapper<User, UserInfoResponse> userMapper;

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(
		@RequestBody @Valid UserCreateRequest userCreateRequest
	) throws ResourceCreateException, ValidationException {
		User user = this.userServices.create(this.userCreateMapper.map(userCreateRequest));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{userId}")
			.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Override
	@PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfoResponse> update(
		@PathVariable("userId") User user,
		@RequestBody @Valid UserUpdateRequest userUpdateRequest
	) throws ResourceCreateException, ValidationException {
		return ResponseEntity.ok(this.userMapper.map(
			this.userServices.update(this.userInfoUpdateInputCreator.create(user, userUpdateRequest))
		));
	}

	@Override
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<Void> delete(
		@PathVariable Integer userId
	) {
		this.userServices.delete(userId);
		return ResponseEntity.noContent().build();
	}

}
