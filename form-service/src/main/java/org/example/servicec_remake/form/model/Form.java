package org.example.servicec_remake.form.model;

import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Form {

    UUID id;

    String name;

    String description;

    boolean active;

    @Builder.Default
    List<AbstractQuestion> questions = new LinkedList<>();
}
