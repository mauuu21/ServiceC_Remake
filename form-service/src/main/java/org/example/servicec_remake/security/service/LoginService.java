package org.example.servicec_remake.security.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.security.model.AuthenticatedUser;
import org.example.servicec_remake.security.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticatedUser login(String userName, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password));

        String token = jwtTokenProvider.createToken(authentication);

        User user = (User) authentication.getPrincipal();


        return AuthenticatedUser.builder()
                .user(user)
                .token(token)
                .build();
    }
}
