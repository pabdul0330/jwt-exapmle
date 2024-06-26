package com.example.jwtexampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class JwtExampleProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtExampleProjectApplication.class, args);
    }

}
