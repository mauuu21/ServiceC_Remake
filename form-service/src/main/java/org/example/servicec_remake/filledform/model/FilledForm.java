package org.example.servicec_remake.filledform.model;

import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FilledForm {

    UUID id;

    UUID formId;

    @Builder.Default
    List<AbstractAnswer> answers = new LinkedList<>();
}
