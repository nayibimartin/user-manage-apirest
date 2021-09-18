package com.example.usermanageapirest.application.configuration.deserialize;

import com.example.usermanageapirest.application.exception.ValueDeserializationException;
import com.example.usermanageapirest.domain.entity.CountryBuilder;
import com.example.usermanageapirest.domain.repository.CountryRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CountryDeserializerTest {

	@InjectMocks
	private CountryDeserializer deserializer;

	@Mock
	private CountryRepository repository;

	private JsonParser jsonParser;

	private DeserializationContext context;

	@BeforeEach
	public void setUp() {
		this.jsonParser = Mockito.mock(JsonParser.class);
		this.context = Mockito.mock(DeserializationContext.class);
	}

	@Test
	public void when_cannot_get_int_value_then_exception_is_thrown() throws IOException {
		Mockito.doThrow(IOException.class).when(this.jsonParser).getIntValue();

		assertThrows(
			ValueDeserializationException.class,
			() -> this.deserializer.deserialize(this.jsonParser, this.context)
		);
	}

	@Test
	public void when_int_value_is_available_then_repository_is_used() throws IOException {
		Mockito.doReturn(1).when(this.jsonParser).getIntValue();

		this.deserializer.deserialize(this.jsonParser, this.context);

		Mockito.verify(this.repository).find(1);
	}

	@Test
	public void when_repository_is_used_then_data_is_returned() throws IOException {
		Mockito.doReturn(4).when(this.jsonParser).getIntValue();
		Mockito.doReturn(Optional.of(new CountryBuilder().build(1)))
			.when(this.repository)
			.find(ArgumentMatchers.anyInt());

		CountryParameter actual = this.deserializer.deserialize(this.jsonParser, this.context);

		assertEquals(new CountryParameter(Optional.of(new CountryBuilder().build(1))), actual);
	}

}