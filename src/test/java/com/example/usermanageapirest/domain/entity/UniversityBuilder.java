package com.example.usermanageapirest.domain.entity;

import com.example.usermanageapirest.builder.Builder;

public class UniversityBuilder extends Builder<University> {
	@Override
	public University build(int index) {
		return new University()
			.setId(index)
			.setCareer("informatics" + index)
			.setName("UCI" + index);
	}
}
