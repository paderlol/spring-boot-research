package com.paderlol.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author paderlol
 * @date: 2019-02-24 13:24
 */
@Controller
public class HelloController {

    @RequestMapping("")
    public String index(){
        return "index";
    }
}
