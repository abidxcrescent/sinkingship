package com.security.sinkingship.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping(value = "/")
    public String hello() {
        return "Hello World";
    }

}
