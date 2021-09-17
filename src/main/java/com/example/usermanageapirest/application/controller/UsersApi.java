package com.example.usermanageapirest.application.controller;

import com.example.usermanageapirest.application.controller.request.UserCreateRequest;
import com.example.usermanageapirest.application.controller.request.UserUpdateRequest;
import com.example.usermanageapirest.application.controller.response.UserInfoResponse;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.exception.ErrorResponse;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "User", description = "Operations to manage users")
public interface UsersApi {

	@Operation(
		summary = "Create new user",
		description = "Create new user",
		operationId = "create",
		tags = {"User"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Successful created user."),
		@ApiResponse(responseCode = "400", description = "Validation exception.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<User> create(
		@RequestBody(description = "New user", required = true) UserCreateRequest userCreateRequest
	) throws ResourceCreateException, ValidationException;

	@Operation(
		summary = "Update user",
		description = "Update user",
		operationId = "update",
		tags = {"User"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Successful updated user."),
		@ApiResponse(responseCode = "400", description = "Validation exception.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<UserInfoResponse> update(
		@Parameter(name = "userId", description = "User Id", required = true) User user,
		@RequestBody(description = "Update user") UserUpdateRequest userUpdateRequest
	) throws ResourceCreateException, ValidationException;
	@Operation(
		summary = "Delete user",
		description = "Delete user",
		operationId = "delete",
		tags = {"User"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successful delete user."),

		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),

		@ApiResponse(responseCode = "404", description = "Entity Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<Void> delete(
		@Parameter(name = "userId", description = "User Id", required = true)
		@PathVariable("userId") Integer userId
	);

}