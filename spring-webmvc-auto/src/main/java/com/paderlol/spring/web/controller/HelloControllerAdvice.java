package com.paderlol.spring.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author paderlol
 * @date: 2019-02-24 17:05
 */
@ControllerAdvice(assignableTypes = HelloController.class)
public class HelloControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message() {
        return "Hello,World";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> exceptionHandle(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }
}
