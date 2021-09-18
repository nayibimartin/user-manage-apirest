package com.example.usermanageapirest.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Accessors(chain = true)
@Data
@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_university")
	@SequenceGenerator(name = "sequence_university", allocationSize = 1)
	private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	private String career;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "universities")
	private List<User> users;

}
