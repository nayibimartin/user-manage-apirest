package com.example.usermanageapirest.infrastructure.persistence;

import com.example.usermanageapirest.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Integer> {

}
