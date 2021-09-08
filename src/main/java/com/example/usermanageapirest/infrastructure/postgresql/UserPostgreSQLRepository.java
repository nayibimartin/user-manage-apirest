package com.example.usermanageapirest.infrastructure.postgresql;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.repository.UserRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.exception.ResourceCreateException;
import com.example.usermanageapirest.infrastructure.persistence.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPostgreSQLRepository implements UserRepository {

	private final UserRepositoryJPA repository;
	private Mapper<UserCreateInput, User> mapper;

	@Autowired
	public UserPostgreSQLRepository(
		UserRepositoryJPA repository,
		Mapper<UserCreateInput, User> mapper
	) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public User create(UserCreateInput input) throws ResourceCreateException {
		return repository.save(this.mapper.map(input));
	}

}
