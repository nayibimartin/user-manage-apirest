package com.example.usermanageapirest.application.controller.university;

import com.example.usermanageapirest.application.controller.university.response.UniversitiesListResponse;
import com.example.usermanageapirest.application.controller.university.response.UniversityResponse;
import com.example.usermanageapirest.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface UniversitiesApi {

	@Operation(
		summary = "List of universities",
		description = "List of universities",
		operationId = "listUniversities",
		tags = {"Users"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Universities"),
		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
		@ApiResponse(responseCode = "404", description = "Entity not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<UniversitiesListResponse> listUniversities(
		@Parameter(name = "userId", description = "User id", required = true) Integer userId
	);

	@Operation(
		summary = "Get university by id",
		description = "Get university by id",
		operationId = "getUniversity",
		tags = {"Users"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Universities"),
		@ApiResponse(responseCode = "403", description = "Resource forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
		@ApiResponse(responseCode = "404", description = "Entity not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<UniversityResponse> getUniversity(
		@Parameter(name = "userId", description = "User id", required = true) Integer userId,
		@Parameter(name = "universityId", description = "University id", required = true) Integer universityId
	);
}
