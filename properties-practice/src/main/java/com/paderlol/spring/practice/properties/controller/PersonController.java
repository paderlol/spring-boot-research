package com.paderlol.spring.practice.properties.controller;

import com.paderlol.spring.practice.properties.format.EmployeeFormatter;
import com.paderlol.spring.practice.properties.pojo.Employee;
import com.paderlol.spring.practice.properties.pojo.Person;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pader
 */
@RestController
public class PersonController {

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addCustomFormatter(new EmployeeFormatter());
    }

    @GetMapping("/person")
    public Person getPerson(@RequestParam("person") Person person) {

        return person;
    }

    @GetMapping("/emp")
    public Employee getPerson(@RequestParam("employee") Employee employee) {

        return employee;
    }

}
