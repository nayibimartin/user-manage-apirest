package com.example.usermanageapirest.application.controller.user.request;

import com.example.usermanageapirest.domain.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserSpecsCreator {

	public static Specification<User> create(String firstName, Integer age) {
		return (root, criteriaQuery, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(firstName != null) {
				predicates.add(criteriaBuilder.equal(root.get("firstName"), firstName));
			}
			if(age != null) {
				predicates.add(criteriaBuilder.equal(root.get("age"), age));
			}
			Optional<Predicate> predicate = predicates.stream().reduce(criteriaBuilder::and);
			return predicate.orElse(null);
		};
	}

}
