package com.paderlol.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author paderlol
 * @date: 2019-02-24 13:24
 */
@Controller
public class HelloController {

    @RequestMapping("")
    public String index(@RequestParam int num) {
        return "index";
    }
}
