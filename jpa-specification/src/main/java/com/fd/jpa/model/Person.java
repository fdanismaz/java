package com.fd.jpa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author furkan.danismaz
 * 10/09/2018 13:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private int id;
	private String name;
	private String surname;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	private LocalDate birthdate;

}
