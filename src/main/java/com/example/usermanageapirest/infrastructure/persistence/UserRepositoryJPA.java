package com.example.usermanageapirest.infrastructure.persistence;

import com.example.usermanageapirest.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends PagingAndSortingRepository<User, Integer> {

}
