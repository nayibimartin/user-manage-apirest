package com.example.usermanageapirest.application.configuration.converter;

import com.example.usermanageapirest.application.exception.EndpointArgumentException;
import com.example.usermanageapirest.application.exception.ResourceNotFoundException;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import com.example.usermanageapirest.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserConverterTest {

	@InjectMocks
	private UserConverter userConverter;

	@Mock
	private UserRepository repository;

	@Test
	public void when_id_is_not_convert_to_integer_then_error_is_throw() {
		assertThrows(EndpointArgumentException.class, () -> this.userConverter.convertId("a"));
	}

	@Test
	public void when_id_is_valid_then_user_is_loaded() {
		Mockito.when(this.repository.find(ArgumentMatchers.anyInt()))
			.thenReturn(Optional.of(new UserBuilder().build(1)));

		this.userConverter.convert("1");

		Mockito.verify(this.repository).find(1);
	}

	@Test
	public void when_user_is_present_then_it_is_return() {
		Mockito.when(this.repository.find(Mockito.anyInt())).thenReturn(
			Optional.of(new UserBuilder().build(1))
		);

		User actual = this.userConverter.convert("1");

		assertEquals(new UserBuilder().build(1), actual);

	}

	@Test
	public void when_user_is_not_present_then_error_is_throw() {
		Mockito.when(this.repository.find(Mockito.anyInt())).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> this.userConverter.convert("1"));
	}

}