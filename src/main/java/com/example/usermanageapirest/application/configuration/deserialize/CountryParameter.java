package com.example.usermanageapirest.application.configuration.deserialize;

import com.example.usermanageapirest.domain.entity.Country;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class CountryParameter {

	private final Optional<Country> country;

}
