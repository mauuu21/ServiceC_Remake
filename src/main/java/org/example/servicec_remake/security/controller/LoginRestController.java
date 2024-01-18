package org.example.servicec_remake.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.security.controller.dto.LoginRequest;
import org.example.servicec_remake.security.controller.dto.LoginResponse;
import org.example.servicec_remake.security.model.AuthenticatedUser;
import org.example.servicec_remake.security.service.LoginService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/login")
public class LoginRestController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AuthenticatedUser authenticatedUser = loginService.login(loginRequest.getUsername(),
                loginRequest.getPassword());


        LoginResponse loginResponse = LoginResponse.builder()
                .username(authenticatedUser.getUser().getUsername())
                .token(authenticatedUser.getToken())
                .id(authenticatedUser.getUser().getId())
                .roles(authenticatedUser.getUser().getRoles())
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + loginResponse.getToken());
        return new ResponseEntity<>(loginResponse, httpHeaders, HttpStatus.OK);
    }
}
