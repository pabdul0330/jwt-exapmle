package com.example.jwtexampleproject.model.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    String username;
    String password;
}
