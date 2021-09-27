package com.example.usermanageapirest.domain.repository;

import com.example.usermanageapirest.domain.entity.University;

import java.util.List;

public interface UniversityRepository {

	List<University> list();

	University get();

}
