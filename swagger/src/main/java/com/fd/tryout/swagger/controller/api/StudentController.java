package com.fd.tryout.swagger.controller.api;

import com.fd.tryout.swagger.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fdanismaz
 * date: 10/12/18 7:35 AM
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student get(@PathVariable("id") String id) {
        return Student.builder().id("1").name("john").surname("doe").build();
    }
}
