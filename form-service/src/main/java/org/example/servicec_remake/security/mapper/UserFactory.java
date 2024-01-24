package org.example.servicec_remake.security.mapper;


import lombok.AllArgsConstructor;
import org.example.servicec_remake.security.controller.dto.RegistrationRequest;
import org.example.servicec_remake.security.model.Role;
import org.example.servicec_remake.security.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserFactory {

    private final PasswordEncoder passwordEncoder;

    public User create(RegistrationRequest registrationRequest) {
        return User.builder()
                .id(UUID.randomUUID())
                .username(registrationRequest.getUsername())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(List.of(Role.ROLE_USER))
                .build();
    }

}
