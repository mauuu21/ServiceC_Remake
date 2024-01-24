package org.example.servicec_remake.filledform.controller.dto;


import lombok.*;
import org.example.servicec_remake.filledform.model.AbstractAnswer;
import org.example.servicec_remake.filledform.model.FreeTextAnswer;
import org.example.servicec_remake.filledform.model.RadioButtonAnswer;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class AnswerDto {

    FreeTextAnswer freeText;

    RadioButtonAnswer radioButton;

    public AbstractAnswer getNotNullValue() {
        if (freeText != null) {
            return freeText;
        }

        return radioButton;
    }

}
