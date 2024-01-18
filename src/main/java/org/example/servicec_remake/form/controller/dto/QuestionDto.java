package org.example.servicec_remake.form.controller.dto;


import lombok.*;
import org.example.servicec_remake.form.model.FreeTextQuestion;
import org.example.servicec_remake.form.model.RadioButtonQuestion;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class QuestionDto {

    FreeTextQuestion freeText;

    RadioButtonQuestion radioButton;

}
