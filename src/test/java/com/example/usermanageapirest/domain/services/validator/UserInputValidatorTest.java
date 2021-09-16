package com.example.usermanageapirest.domain.services.validator;

import com.example.usermanageapirest.domain.entity.UserBuilder;
import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserCreateInputBuilder;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import com.example.usermanageapirest.domain.services.input.UserUpdateInputBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserInputValidatorTest {

	@InjectMocks
	private UserInputValidator validator;

	@Test
	public void when_user_create_input_language_is_different_then_exception_is_throw() throws ValidationException {
		UserCreateInput actual = new UserCreateInputBuilder().build(1)
			.setLanguage("english");

		assertThrows(ValidationException.class, () -> this.validator.validateUserCreateInput(actual));
	}

	@Test
	public void when_user_info_update_input_language_is_different_then_exception_is_throw() throws ValidationException {
		UserInfoUpdateInput actual = new UserInfoUpdateInput()
			.setUser(new UserBuilder().build(1))
			.setUserUpdateInput(new UserUpdateInputBuilder().build(1).setLanguage("english"));

		assertThrows(ValidationException.class, () -> this.validator.validateUserInfoUpdateInput(actual));
	}

}