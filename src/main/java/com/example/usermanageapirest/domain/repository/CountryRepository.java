package com.example.usermanageapirest.domain.repository;

import com.example.usermanageapirest.domain.entity.Country;

import java.util.Optional;

public interface CountryRepository {

	Optional<Country> find(int id);

	String findLanguage(int id);

}
