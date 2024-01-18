package org.example.servicec_remake.form.controller.dto;

import lombok.*;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FormDto {

    String id;

    String name;

    String description;

    @Builder.Default
    boolean active = true;

    List<QuestionDto> questions;

}
