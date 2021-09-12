package com.example.usermanageapirest.application.controller;

import com.example.usermanageapirest.application.controller.request.UserCreateRequest;
import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.services.UserServices;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.exception.ResourceCreateException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(
		@RequestBody @Valid UserCreateRequest userCreateRequest
	) throws ResourceCreateException, ValidationException {
		User user=this.userServices.create(this.userCreateMapper.map(userCreateRequest));
		URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{userId}")
			.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
