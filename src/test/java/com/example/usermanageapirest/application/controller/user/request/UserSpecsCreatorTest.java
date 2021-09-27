package com.example.usermanageapirest.application.controller.user.request;

import com.example.usermanageapirest.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserSpecsCreatorTest {

	@Mock
	private Root<User> root;

	@Mock
	private CriteriaQuery<User> criteriaQuery;

	@Mock
	private CriteriaBuilder criteriaBuilder;

	@Test
	public void when_all_params_are_null_then_spec_is_return_null() {
		Specification<User> actual = UserSpecsCreator.create(null, null);
		Predicate actualPredicate = actual.toPredicate(this.root, this.criteriaQuery, this.criteriaBuilder);

		assertNull(actualPredicate);
	}

	@Test
	public void when_create_specs_then_root_is_used() {
		Path firstNamePath = mock(Path.class);
		when(this.root.get("firstName")).thenReturn(firstNamePath);
		Predicate firstNamePredicate = mock(Predicate.class);
		when(this.criteriaBuilder.equal(firstNamePath, "pepe")).thenReturn(firstNamePredicate);
		Path agePath = mock(Path.class);
		when(this.root.get("age")).thenReturn(agePath);
		Predicate agePredicate = mock(Predicate.class);
		when(this.criteriaBuilder.equal(agePath, 1)).thenReturn(agePredicate);
		Predicate predicate = mock(Predicate.class);
		when(this.criteriaBuilder.and(firstNamePredicate, agePredicate)).thenReturn(predicate);

		Specification<User> actual = UserSpecsCreator.create("pepe", 1);
		Predicate actualPredicate = actual.toPredicate(this.root, this.criteriaQuery, this.criteriaBuilder);

		verify(this.root, times(1)).get("firstName");
		verify(this.root, times(1)).get("age");
		verifyNoMoreInteractions(this.root);
	}

	@Test
	public void when_create_specs_then_criteria_builder_is_used() {
		Path firstNamePath = mock(Path.class);
		when(this.root.get("firstName")).thenReturn(firstNamePath);
		Predicate firstNamePredicate = mock(Predicate.class);
		when(this.criteriaBuilder.equal(firstNamePath, "pepe")).thenReturn(firstNamePredicate);
		Path agePath = mock(Path.class);
		when(this.root.get("age")).thenReturn(agePath);
		Predicate agePredicate = mock(Predicate.class);
		when(this.criteriaBuilder.equal(agePath, 1)).thenReturn(agePredicate);
		Predicate predicate = mock(Predicate.class);
		when(this.criteriaBuilder.and(firstNamePredicate, agePredicate)).thenReturn(predicate);

		Specification<User> actual = UserSpecsCreator.create("pepe", 1);
		Predicate actualPredicate = actual.toPredicate(this.root, this.criteriaQuery, this.criteriaBuilder);

		verify(this.criteriaBuilder, times(1)).equal(firstNamePath, "pepe");
		verify(this.criteriaBuilder, times(1)).equal(agePath, 1);
		verify(this.criteriaBuilder, times(1)).and(firstNamePredicate, agePredicate);
		verifyNoMoreInteractions(this.criteriaBuilder);
	}

	@Test
	public void when_params_are_not_null_then_spec_is_return() {
		Path firstNamePath = mock(Path.class);
		when(this.root.get("firstName")).thenReturn(firstNamePath);
		Predicate firstNamePredicate = mock(Predicate.class);
		when(this.criteriaBuilder.equal(firstNamePath, "pepe")).thenReturn(firstNamePredicate);
		Path agePath = mock(Path.class);
		when(this.root.get("age")).thenReturn(agePath);
		Predicate agePredicate = mock(Predicate.class);
		when(this.criteriaBuilder.equal(agePath, 1)).thenReturn(agePredicate);
		Predicate predicate = mock(Predicate.class);
		when(this.criteriaBuilder.and(firstNamePredicate, agePredicate)).thenReturn(predicate);

		Specification<User> actual = UserSpecsCreator.create("pepe", 1);
		Predicate actualPredicate = actual.toPredicate(this.root, this.criteriaQuery, this.criteriaBuilder);

		assertEquals(predicate, actualPredicate);
	}

}