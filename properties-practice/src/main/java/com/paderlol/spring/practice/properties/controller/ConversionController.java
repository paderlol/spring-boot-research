package com.paderlol.spring.practice.properties.controller;

import com.paderlol.spring.practice.properties.editor.CreditCard;
import com.paderlol.spring.practice.properties.editor.CustomExoticTypeEditor;
import com.paderlol.spring.practice.properties.format.EmployeeFormatter;
import com.paderlol.spring.practice.properties.pojo.Employee;
import com.paderlol.spring.practice.properties.pojo.ExoticType;
import com.paderlol.spring.practice.properties.pojo.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pader
 */
@RestController
public class ConversionController {

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addCustomFormatter(new EmployeeFormatter());
        binder.registerCustomEditor(ExoticType.class,
                new CustomExoticTypeEditor());
    }

    @GetMapping("/person")
    public Person getPerson(@RequestParam("person") Person person) {

        return person;
    }

    @GetMapping("/emp")
    public Employee getPerson(@RequestParam("employee") Employee employee) {

        return employee;
    }

    @GetMapping(value = "/credit-card/{card-no}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreditCard parseCreditCardNumber(
            @PathVariable("card-no") CreditCard creditCard) {
        return creditCard;
    }

    @GetMapping(
            value = "/exotic-type/{value}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ExoticType parseExoticType(
            @PathVariable("value") ExoticType exoticType) {
        return exoticType;
    }

}
