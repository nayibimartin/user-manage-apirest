package com.example.usermanageapirest.application.controller.user.request;

import static org.junit.jupiter.api.Assertions.*;

import com.example.usermanageapirest.application.controller.user.response.PageResponse;
import com.example.usermanageapirest.application.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserPageableCreatorTest {
	@InjectMocks
	private UserPageableCreator creator;

	@Mock
	private ParameterValueDecider parameterValueDecider;

	@Mock
	private Validator<String> orderValidator;

	@Mock
	private Validator<Integer> pageValidator;

	@Mock
	private Validator<Integer> sizeValidator;

	@Test
	public void when_creator_is_used_then_request_is_created() {
		Mockito.when(parameterValueDecider.decideValue(Mockito.any(), Mockito.any(), Mockito.any()))
			.thenReturn("firstName.asc", 1, 10);

		Pageable actual = this.creator.create(
			1,
			10,
			"firstName.asc"
		);

		assertEquals(1, actual.getPageNumber());
		assertEquals(10, actual.getPageSize());
		assertEquals(Sort.by("firstName").ascending(),actual.getSort());
	}

}