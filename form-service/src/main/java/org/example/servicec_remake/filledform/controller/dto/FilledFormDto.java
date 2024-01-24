package org.example.servicec_remake.filledform.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FilledFormDto {

    UUID id;

    @JsonProperty("form-id")
    UUID formId;

    List<AnswerDto> answers;

}
