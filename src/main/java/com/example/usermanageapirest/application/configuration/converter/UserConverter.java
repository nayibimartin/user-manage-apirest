package com.example.usermanageapirest.application.configuration.converter;

import com.example.usermanageapirest.application.exception.EndpointArgumentException;
import com.example.usermanageapirest.application.exception.ResourceNotFoundException;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserConverter implements Converter<String, User> {

	private final UserRepository repository;

	@Autowired
	public UserConverter(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User convert(String id) {
		Optional<User> user = this.repository.find(this.convertId(id));
		if(user.isPresent()) {
			return user.get();
		}
		throw new ResourceNotFoundException(String.format("Cannot find user %s", id));
	}

	public Integer convertId(String id) {
		try {
			return Integer.parseInt(id);
		} catch(NumberFormatException e) {
			throw new EndpointArgumentException(String.format("Cannot convert %s to int", id), e);
		}
	}
}
