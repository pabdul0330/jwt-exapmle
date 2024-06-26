package com.example.jwtexampleproject.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    String username;
    String password;
}
