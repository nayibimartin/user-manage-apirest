package com.example.usermanageapirest.domain.services;

import com.example.usermanageapirest.application.exception.ResourceNotFoundException;
import com.example.usermanageapirest.domain.entity.University;
import com.example.usermanageapirest.domain.exception.ResourceFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServices {

	private UserServices userServices;

	@Autowired
	public UniversityServices(UserServices userServices) {
		this.userServices = userServices;
	}

	public List<University> listUniversities(Integer userId) throws ResourceNotFoundException, ResourceFindException {
		return this.userServices.get(userId).getUniversities();
	}

	public University getUniversity(
		Integer userId,
		Integer universityId
	) throws ResourceNotFoundException, ResourceFindException {
		return this.userServices.get(userId)
			.getUniversities()
			.stream()
			.filter(university -> university.getId().equals(universityId))
			.findFirst()
			.orElse(null);
	}

}
