package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.domain.entity.Country;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserUpdateInput {

	private int age;
	private String language;
	private int rank;
	private Country country;
	private boolean active;

}
