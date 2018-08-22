package com.paderlol.spring.devtool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dev")
public class DevController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World!!2223";
    }
}
