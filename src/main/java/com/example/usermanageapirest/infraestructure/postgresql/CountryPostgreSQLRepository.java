package com.example.usermanageapirest.infraestructure.postgresql;

import com.example.usermanageapirest.domain.entity.Country;
import com.example.usermanageapirest.domain.repository.CountryRepository;
import com.example.usermanageapirest.infraestructure.persistence.CountryRepositoryJPA;
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

	@Override
	public String findLanguage(int id) {
		return this.repository.findById(id).get().getLanguage();
	}
}
