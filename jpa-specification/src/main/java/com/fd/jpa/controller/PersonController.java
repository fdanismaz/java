package com.fd.jpa.controller;

import com.fd.jpa.converter.CycleAvoidingMappingContext;
import com.fd.jpa.converter.PersonEntityMapper;
import com.fd.jpa.entity.PersonEntity;
import com.fd.jpa.model.Person;
import com.fd.jpa.repository.person.PersonRepository;
import com.fd.jpa.repository.person.PersonSpecifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author furkan.danismaz
 * 10/09/2018 13:48
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

	@Autowired
	private PersonEntityMapper personEntityMapper;

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		Optional<PersonEntity> queryResult = this.personRepository.findById(id);
		if (queryResult.isPresent()) {
			return this.personEntityMapper.toBusinessObject(queryResult.get(), new CycleAvoidingMappingContext(), this.getRequestTimeZone());
		}
		return null;
	}

	@GetMapping("/search")
	public List<Person> search(@RequestParam String name, @RequestParam String surname) {
		List<PersonEntity> searchResult = this.personRepository.findAll(
				Specification.where(PersonSpecifications.withName(name))
						.and(PersonSpecifications.withSurname(surname)));
		return this.personEntityMapper.toBusinessObjectList(searchResult, new CycleAvoidingMappingContext(), this.getRequestTimeZone());
	}

	@PostMapping
	public Person savePerson(@RequestBody Person person, HttpServletRequest request) {
		PersonEntity personEntity = this.personEntityMapper.toEntity(person, new CycleAvoidingMappingContext(), this.getRequestTimeZone());
		this.personRepository.save(personEntity);
		person.setId(personEntity.getId());
		return person;
	}

}
