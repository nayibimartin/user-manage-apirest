package com.example.usermanageapirest.application.controller.user;

import com.example.usermanageapirest.application.controller.user.request.UserCreateRequest;
import com.example.usermanageapirest.application.controller.user.request.UserUpdateRequest;
import com.example.usermanageapirest.application.controller.user.response.UserInfoResponse;
import com.example.usermanageapirest.application.controller.user.response.UserListResponse;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.exception.BadRequest;
import com.example.usermanageapirest.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User", description = "Operations to manage users")
public interface UsersApi {

	@Operation(
		summary = "Create new user",
		description = "Create new user",
		operationId = "create",
		tags = {"Users"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Successful created user.", headers = @Header(name = "location", description = "Url resource", schema = @Schema(type = "string"))),
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
		tags = {"Users"}
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
		summary = "List of users",
		description = "List of users",
		operationId = "list",
		tags = {"Users"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "List of users"),
		@ApiResponse(responseCode = "400", description = "Bad request Available codes:   " +
			"- PAGING_INVALID_PAGE: Number of the page is not valid/is not a number   " +
			"- PAGING_INVALID_SIZE: Number of results per page is not valid/is not a number   " +
			"- SORTING_INVALID_FIELD: Field does not exist or it is not sortable   " +
			"- SORTING_INVALID_ORDER: Order is not valid ",
			content = @Content(schema = @Schema(implementation = BadRequest.class))),
		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<UserListResponse> list(
		@Parameter(name = "page", description = "Number of the page that will be returned starting at 0") Integer page,
		@Parameter(name = "size", description = "Number of results per page (20 by default)") Integer size,
		@Parameter(name = "sort", description = "Sorted results by field and order asc") String sort,
		@Parameter(name = "firstName", description = "Name of the user to filter by") String firstName,
		@Parameter(name = "age", description = "Age of the user to filter by") Integer age
	);

	@Operation(
		summary = "Get user by id",
		description = "Get user by id",
		operationId = "getUser",
		tags = {"Users"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "User"),
		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
		@ApiResponse(responseCode = "404", description = "Entity Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<UserInfoResponse> getUser(
		@Parameter(name = "userId", description = "User Id", required = true) Integer userId
	);

}