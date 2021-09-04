package com.example.usermanageapirest.domain.services.input;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserCreateInput {

	private String firstName;
	private String lastName;
	private int age;
	private String language;
	private int rank;
	private String country;
	private String active;

}
