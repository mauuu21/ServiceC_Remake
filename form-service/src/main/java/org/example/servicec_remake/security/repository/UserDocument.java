package org.example.servicec_remake.security.repository;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.servicec_remake.security.model.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(value = "users")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDocument {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private List<Role> roles;


}
