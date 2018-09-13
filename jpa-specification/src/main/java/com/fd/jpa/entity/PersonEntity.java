package com.fd.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

/**
 * @author furkan.danismaz
 * 10/09/2018 13:41
 */
@Data
@Entity
@Table(name = "PEOPLE")
public class PersonEntity extends EntityModel {

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "BIRTHDATE")
	private Instant birthdate;
}
