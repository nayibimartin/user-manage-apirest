package com.example.usermanageapirest.infrastructure.postgresql;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.exception.ResourceCreateException;
import com.example.usermanageapirest.domain.exception.ResourceFindException;
import com.example.usermanageapirest.domain.exception.ResourceUpdateException;
import com.example.usermanageapirest.domain.repository.UserRepository;
import com.example.usermanageapirest.domain.services.input.UserCreateInput;
import com.example.usermanageapirest.domain.services.input.UserInfoUpdateInput;
import com.example.usermanageapirest.infrastructure.persistence.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPostgreSQLRepository implements UserRepository {

	private final UserRepositoryJPA repository;
	private Mapper<UserCreateInput, User> userCreateMapper;
	private Mapper<UserInfoUpdateInput, User> userInfoUpdateMapper;

	@Autowired
	public UserPostgreSQLRepository(
		UserRepositoryJPA repository,
		Mapper<UserCreateInput, User> userCreateMapper,
		Mapper<UserInfoUpdateInput, User> userInfoUpdateMapper
	) {
		this.repository = repository;
		this.userCreateMapper = userCreateMapper;
		this.userInfoUpdateMapper = userInfoUpdateMapper;
	}

	@Override
	public User create(UserCreateInput input) throws ResourceCreateException {
		return this.repository.save(this.userCreateMapper.map(input));
	}

	@Override
	public Optional<User> find(Integer id) throws ResourceFindException {
		return this.repository.findById(id);
	}

	@Override
	public User update(UserInfoUpdateInput input) throws ResourceUpdateException {
		return this.repository.save(this.userInfoUpdateMapper.map(input));
	}

	@Override
	public Page<User> list(Pageable pageable, Specification<User> specs) throws ResourceFindException {
		return this.repository.findAll(specs, pageable);
	}

}
