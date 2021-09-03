package com.example.usermanageapirest.domain.services.input;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserCreateInput {

	private String firstname;

	private String lastname;

	private int age;

	private String language;

	private int rank;

	private String country;

	private String active;
}
