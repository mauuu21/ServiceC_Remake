package org.example.servicec_remake.security.model;

import lombok.*;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class AuthenticatedUser {

    User user;

    String token;
}
