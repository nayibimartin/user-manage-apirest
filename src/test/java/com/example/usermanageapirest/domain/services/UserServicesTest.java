package com.example.usermanageapirest.domain.services;

import com.example.usermanageapirest.application.controller.user.response.PageBuilder;
import com.example.usermanageapirest.application.exception.ResourceNotFoundException;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.repository.UserRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInputBuilder;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import com.example.usermanageapirest.domain.services.input.UserUpdateInputBuilder;
import com.example.usermanageapirest.domain.services.validator.UserInputValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

	@InjectMocks
	private UserServices services;

	@Mock
	private UserRepository repository;

	@Mock
	private UserInputValidator validator;

	@Test
	public void when_create_then_create_input_is_validated() throws ValidationException {
		this.services.create(new UserCreateInputBuilder().build(1));

		Mockito.verify(this.validator).validateUserCreateInput(new UserCreateInputBuilder().build(1));
	}

	@Test
	public void when_create_input_is_not_valid_then_exception_is_throw() throws ValidationException {
		Mockito.doThrow(ValidationException.class)
			.when(this.validator).validateUserCreateInput(any());

		assertThrows(ValidationException.class, () -> this.services.create(new UserCreateInputBuilder().build(1)));
	}

	@Test
	public void when_create_input_is_valid_then_repository_is_used() throws ValidationException {
		this.services.create(new UserCreateInputBuilder().build(1));

		Mockito.verify(this.repository).create(new UserCreateInputBuilder().build(1));
	}

	@Test
	public void when_user_create_not_create_then_exception_is_throw() throws ResourceCreateException {
		Mockito.doThrow(ResourceCreateException.class)
			.when(this.repository).create(any());

		assertThrows(
			ResourceCreateException.class,
			() -> this.repository.create(new UserCreateInputBuilder().build(1))
		);
	}

	@Test
	public void when_user_update_then_input_is_validated() throws ValidationException {
		this.services.update(new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1))
		);

		Mockito.verify(this.validator).validateUserInfoUpdateInput(new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1))
		);
	}

	@Test
	public void when_update_input_is_not_valid_then_exception_is_throw() throws ValidationException {
		Mockito.doThrow(ValidationException.class)
			.when(this.validator).validateUserInfoUpdateInput(any());

		assertThrows(ValidationException.class, () -> this.services.update(new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1))
		));
	}

	@Test
	public void when_update_input_is_valid_then_repository_is_used() throws ValidationException {
		this.services.update(new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1)));

		Mockito.verify(this.repository).update(new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1)));
	}

	@Test
	public void when_user_update_not_update_then_exception_is_throw() throws ResourceCreateException {
		Mockito.doThrow(ResourceCreateException.class)
			.when(this.repository).update(any());

		assertThrows(
			ResourceCreateException.class,
			() -> this.repository.update(new UserInfoUpdateInput()
				.setUser(new UserBuilder().build(1))
				.setUserUpdateInput(new UserUpdateInputBuilder().build(1))
			)
		);
	}

	@Test
	public void when_get_user_then_repository_is_used() throws ResourceNotFoundException {
		Mockito.when(this.repository.find(any())).thenReturn(Optional.of(new UserBuilder().build(1)));

		this.services.get(1);

		Mockito.verify(this.repository).find(1);
	}

	@Test
	public void when_user_not_found_then_exception_is_throw() throws ResourceNotFoundException {
		Mockito.when(this.repository.find(any())).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, ()->this.services.get(1));
	}

	@Test
	public void when_list_user_then_repository_is_used() {
		Mockito.when(this.repository.list(any(), any())).thenReturn(new PageBuilder().build(1));

		this.services.list(Pageable.ofSize(1),null);

		Mockito.verify(this.repository).list(Pageable.ofSize(1),null);
	}

}