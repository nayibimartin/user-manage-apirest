package com.example.usermanageapirest.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Accessors(chain = true)
@Data
@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_country")
	@SequenceGenerator(name = "sequence_country", allocationSize = 1)
	private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	private String language;

}
