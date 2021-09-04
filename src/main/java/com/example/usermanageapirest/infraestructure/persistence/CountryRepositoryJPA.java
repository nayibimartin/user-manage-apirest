package com.example.usermanageapirest.infraestructure.persistence;

import com.example.usermanageapirest.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoryJPA extends JpaRepository<Country, Integer> {

}
