package com.example.usermanageapirest.domain.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Builder
@Accessors(chain = true)
@Data
@AllArgsConstructor
@Entity()
@Table(name = "users")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_user")
	@SequenceGenerator(name = "sequence_user", allocationSize = 1)
	private int id;

	@NotNull
	private String firstname;

	@NotNull
	private String lastname;

	@NotNull
	private int age;

	@NotNull
	private String language;

	@NotNull
	private int rank;

	@NotNull
	private String country;

	@NotNull
	private String active;
}
