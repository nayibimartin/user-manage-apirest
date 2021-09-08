package com.example.usermanageapirest.infrastructure.postgresql;

import com.example.usermanageapirest.domain.entity.Country;
import com.example.usermanageapirest.domain.repository.CountryRepository;
import com.example.usermanageapirest.infrastructure.persistence.CountryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryPostgreSQLRepository implements CountryRepository {

	private final CountryRepositoryJPA repository;

	@Autowired
	public CountryPostgreSQLRepository(CountryRepositoryJPA repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Country> find(int id) {
		return this.repository.findById(id);
	}
}
