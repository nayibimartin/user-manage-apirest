package com.example.usermanageapirest.application.controller.university;

import com.example.usermanageapirest.application.controller.university.response.UniversitiesListResponse;
import com.example.usermanageapirest.application.controller.university.response.UniversitiesListResponseCreator;
import com.example.usermanageapirest.application.controller.university.response.UniversitiesResponseMapper;
import com.example.usermanageapirest.application.controller.university.response.UniversityResponse;
import com.example.usermanageapirest.domain.services.UniversityServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UniversitiesApiController implements UniversitiesApi {

	private final UniversitiesListResponseCreator universitiesListResponseCreator;
	private final UniversityServices universityService;
	private final UniversitiesResponseMapper universitiesResponseMapper;

	@Override
	@GetMapping(value = "/{userId}/universities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UniversitiesListResponse> listUniversities(
		@PathVariable Integer userId
	) {
		return ResponseEntity.ok(this.universitiesListResponseCreator.create(this.universityService.listUniversities(
			userId)));
	}

	@Override
	@GetMapping(value = "/{userId}/universities/{universityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UniversityResponse> getUniversity(
		@PathVariable("userId") Integer userId,
		@PathVariable("universityId") Integer universityId
	) {
		return ResponseEntity.ok(this.universitiesResponseMapper.map(this.universityService.getUniversity(
			userId,
			universityId
		)));
	}
}
