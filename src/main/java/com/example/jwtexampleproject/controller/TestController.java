package com.example.jwtexampleproject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class TestController {
    @GetMapping("user")
//    @PreAuthorize("hasRole('USER')")
    public String method1() {
        return "Hello user!";
    }

    @GetMapping("admin")
//    @PreAuthorize("hasRole('ADMIN')")
    public String method2() {
        return "Hello admin!";
    }
}
