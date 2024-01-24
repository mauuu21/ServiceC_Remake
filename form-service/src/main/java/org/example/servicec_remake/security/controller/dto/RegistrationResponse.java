package org.example.servicec_remake.security.controller.dto;

import lombok.*;

import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class RegistrationResponse {

    UUID id;

    String username;

}
