package com.example.jwtexampleproject.service.auth;

import com.example.jwtexampleproject.dao.entity.UserEntity;
import com.example.jwtexampleproject.dao.repository.UserRepository;
import com.example.jwtexampleproject.model.request.LoginRequest;
import com.example.jwtexampleproject.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

//    public void register(UserRegisterRequestDto requestDto) {
//        var user = UserRegisterRequestDto.builder()
//                .firstName(requestDto.getFirstName())
//                .lastName(requestDto.getLastName())
//                .email(requestDto.getEmail())
//                .password(passwordEncoder.encode(requestDto.getPassword()))
//                .roles(requestDto.getRoles())
//                .build();
//
//        userRepository.save(usermapper.mapRegisterRequestDtoToEntity(user));
//    }

    public LoginResponse authenticate(LoginRequest loginRequest) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList()));
        var jwtToken = jwtService.generateToken(userDetails);
        return LoginResponse.builder()
                .token(jwtToken)
                .build();
    }

}