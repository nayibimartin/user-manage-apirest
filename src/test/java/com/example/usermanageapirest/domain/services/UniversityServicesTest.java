package com.example.usermanageapirest.domain.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.usermanageapirest.application.exception.ResourceNotFoundException;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversityServicesTest {

	@InjectMocks
	private UniversityServices universityServices;

	@Mock
	private UserServices userServices;

	@Test
	public void when_list_universities_then_user_services_is_used() {
		Mockito.when(this.userServices.get(ArgumentMatchers.anyInt())).thenReturn(new UserBuilder().build(1));

		this.universityServices.listUniversities(1);

		Mockito.verify(this.userServices).get(1);
	}

	@Test
	public void when_user_not_found_then_exception_is_throw() throws ResourceNotFoundException{
		Mockito.when(this.userServices.get(ArgumentMatchers.anyInt())).thenThrow(ResourceNotFoundException.class);

		assertThrows(ResourceNotFoundException.class,()->this.universityServices.listUniversities(1));
	}

	@Test
	public void when_get_university_then_user_services_is_used() {
		Mockito.when(this.userServices.get(ArgumentMatchers.anyInt())).thenReturn(new UserBuilder().build(1));

		this.universityServices.getUniversity(1,1);

		Mockito.verify(this.userServices).get(1);
	}

	@Test
	public void when_user_in_get_not_found_then_exception_is_throw() throws ResourceNotFoundException{
		Mockito.when(this.userServices.get(ArgumentMatchers.anyInt())).thenThrow(ResourceNotFoundException.class);

		assertThrows(ResourceNotFoundException.class,()->this.universityServices.getUniversity(1,1));
	}

	@Test
	public void when_university_not_found_then_null_is_return() throws ResourceNotFoundException{
		Mockito.when(this.userServices.get(ArgumentMatchers.anyInt())).thenReturn(new UserBuilder().build(1));

		assertNull(this.universityServices.getUniversity(1,4));
	}


}