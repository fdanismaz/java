package com.fd.tryout.springbatch.batch;

import com.fd.tryout.springbatch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author furkand
 * 10/26/2018 6:04 PM
 */
@Slf4j
public class PersonProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        log.info("Converting person: " + person.toString());
        return Person.builder()
                .name(person.getName().toUpperCase())
                .surname(person.getSurname().toUpperCase()).build();
    }
}
