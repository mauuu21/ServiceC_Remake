package org.example.servicec_remake.security.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class RegistrationRequest {

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    String passwordAgain;
}
