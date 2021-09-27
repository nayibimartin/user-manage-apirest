package com.example.usermanageapirest.application.controller.user;

import com.example.usermanageapirest.application.controller.user.request.UserCreateRequest;
import com.example.usermanageapirest.application.controller.user.request.UserInfoUpdateInputCreator;
import com.example.usermanageapirest.application.controller.user.request.UserPageableCreator;
import com.example.usermanageapirest.application.controller.user.request.UserSpecsCreator;
import com.example.usermanageapirest.application.controller.user.request.UserUpdateRequest;
import com.example.usermanageapirest.application.controller.user.response.UserInfoResponse;
import com.example.usermanageapirest.application.controller.user.response.UserListResponse;
import com.example.usermanageapirest.application.controller.user.response.UserListResponseCreator;
import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.services.UserServices;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersApiController implements UsersApi {

	private final UserServices userServices;
	private final Mapper<UserCreateRequest, UserCreateInput> userCreateInputMapper;
	private final UserInfoUpdateInputCreator userInfoUpdateInputCreator;
	private final Mapper<User, UserInfoResponse> userInfoResponseMapper;
	private final UserPageableCreator pageableCreator;
	private final UserListResponseCreator userListResponseCreator;
	private final UserSpecsCreator userSpecsCreator;

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(
		@RequestBody @Valid UserCreateRequest userCreateRequest
	) throws ResourceCreateException, ValidationException {
		User user = this.userServices.create(this.userCreateInputMapper.map(userCreateRequest));
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
		return ResponseEntity.ok(this.userInfoResponseMapper.map(
			this.userServices.update(this.userInfoUpdateInputCreator.create(user, userUpdateRequest))
		));
	}

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResponse> list(
		@RequestParam(value = "page", required = false) Integer page,
		@RequestParam(value = "size", required = false) Integer size,
		@RequestParam(value = "sort", required = false) String sort,
		@RequestParam(value = "firstName", required = false) String firstName,
		@RequestParam(value = "age", required = false) Integer age
	) {
		return ResponseEntity.ok(
			this.userListResponseCreator.create(
				this.userServices.list(
					this.pageableCreator.create(page, size, sort),
					this.userSpecsCreator.create(firstName, age)
				)
			)
		);
	}

	@Override
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfoResponse> getUser(
		@PathVariable("userId") Integer userId
	) {
		return ResponseEntity.ok(this.userInfoResponseMapper.map(this.userServices.get(userId)));
	}

}
