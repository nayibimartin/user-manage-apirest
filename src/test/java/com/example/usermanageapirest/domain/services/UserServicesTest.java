package com.example.usermanageapirest.domain.services;

import com.example.usermanageapirest.domain.entity.UserBuilder;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.application.exception.ResourceNotFoundException;
import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ResourceDeleteException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

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
	public void when_create_input_is_valid_then_repository_is_used() {
		this.repository.create(new UserCreateInputBuilder().build(1));

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
	public void when_update_input_is_valid_then_repository_is_used() {
		this.repository.update(new UserInfoUpdateInput()
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
	public void when_delete_then_repository_is_used() {
		this.repository.delete(1);

		Mockito.verify(this.repository).delete(1);
	}

	@Test
	public void when_user_delete_not_found_then_exception_is_throw() throws ResourceNotFoundException {
		Mockito.doThrow(ResourceNotFoundException.class)
			.when(this.repository).delete(any());

		assertThrows(
			ResourceNotFoundException.class,
			() -> this.repository.delete(1)
		);
	}

	@Test
	public void when_user_delete_not_delete_then_exception_is_throw() throws ResourceDeleteException {
		Mockito.doThrow(ResourceDeleteException.class)
			.when(this.repository).delete(any());

		assertThrows(
			ResourceDeleteException.class,
			() -> this.repository.delete(1)
		);
	}

}