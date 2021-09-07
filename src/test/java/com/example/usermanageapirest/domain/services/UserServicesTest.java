package com.example.usermanageapirest.domain.services;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.repository.UserRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserCreateInputBuilder;
import com.example.usermanageapirest.domain.services.validator.UserCreateInputValidator;
import com.example.usermanageapirest.exception.ResourceCreateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

	@InjectMocks
	public UserServices services;

	@Mock
	public UserRepository repository;

	@Mock
	public UserCreateInputValidator validator;

	@Mock
	public Mapper<UserCreateInput, User> mapper;

	@Test
	public void when_create_then_input_is_validated() throws ValidationException {
		this.services.create(new UserCreateInputBuilder().build(1));

		Mockito.verify(validator).validateLanguage(new UserCreateInputBuilder().build(1));
	}

	@Test
	public void when_input_is_not_valid_then_exception_is_throw() throws ValidationException {
		Mockito.doThrow(ValidationException.class)
			.when(this.validator).validateLanguage(ArgumentMatchers.any());

		assertThrows(ValidationException.class, () -> this.services.create(new UserCreateInputBuilder().build(1)));
	}

	@Test
	public void when_input_is_valid_then_repository_is_used() {
		this.repository.create(new UserCreateInputBuilder().build(1));

		Mockito.verify(this.repository).create(new UserCreateInputBuilder().build(1));
	}

	@Test
	public void when_user_not_create_then_exception_is_throw() throws ResourceCreateException{
		Mockito.doThrow(ResourceCreateException.class)
			.when(this.repository).create(ArgumentMatchers.any());

		assertThrows(
			ResourceCreateException.class,
			() -> this.repository.create(new UserCreateInputBuilder().build(1))
		);
	}

}