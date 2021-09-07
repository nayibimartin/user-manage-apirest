package com.example.usermanageapirest.domain.services.validator;

import com.example.usermanageapirest.domain.exception.ValidationException;
import com.example.usermanageapirest.domain.repository.CountryRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserCreateInputBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCreateInputValidatorTest {

	@InjectMocks
	private UserCreateInputValidator validator;

	@Test
	public void when_language_is_different_then_exception_is_throw() throws ValidationException {
		UserCreateInput actual= new UserCreateInputBuilder().build(1)
			.setLanguage("english");

		assertThrows(ValidationException.class,()->this.validator.validateLanguage(actual));
	}

}