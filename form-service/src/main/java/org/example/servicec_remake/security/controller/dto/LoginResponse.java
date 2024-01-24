package org.example.servicec_remake.security.controller.dto;


import lombok.*;
import org.example.servicec_remake.security.model.Role;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class LoginResponse {

    UUID id;

    String username;

    String token;

    @Builder.Default
    List<Role> roles = Collections.emptyList();

}
