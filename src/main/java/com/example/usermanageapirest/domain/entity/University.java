package com.example.usermanageapirest.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Data
@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_university")
	@SequenceGenerator(name = "sequence_university", allocationSize = 1)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "career", nullable = false)
	private String career;

	@ManyToMany(targetEntity = User.class, mappedBy = "universities", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<>();

}
