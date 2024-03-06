package org.example.servicec_remake.steps.dto;

import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class LoginResponse {

    UUID id;

    String userName;

    String token;

    @Builder.Default
    List<Role> roles = Collections.emptyList();
}
