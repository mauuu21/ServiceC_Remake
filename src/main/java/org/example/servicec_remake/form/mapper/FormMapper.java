package org.example.servicec_remake.form.mapper;


import org.example.servicec_remake.form.controller.dto.FormDto;
import org.example.servicec_remake.form.controller.dto.QuestionDto;
import org.example.servicec_remake.form.model.AbstractQuestion;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.model.FreeTextQuestion;
import org.example.servicec_remake.form.model.RadioButtonQuestion;
import org.example.servicec_remake.form.repository.FormDocument;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface FormMapper {

    default Form convertToForm(FormDto formDto) {
        return Form.builder()
                .id(formDto.getId() == null ? null : UUID.fromString(formDto.getId()))
                .name(formDto.getName())
                .description(formDto.getDescription())
                .active(formDto.isActive())
                .questions(getAbstractQuestions(formDto.getQuestions()))
                .build();
    }

    private List<AbstractQuestion> getAbstractQuestions(List<QuestionDto> questionDtos) {
        return questionDtos
                .stream()
                .map(questionDto -> {
                    if (questionDto.getFreeText() != null) {
                        return questionDto.getFreeText();
                    } else {
                        return questionDto.getRadioButton();
                    }
                }).collect(Collectors.toList());
    }

    default FormDto convertToFormDto(Form form) {
        return FormDto.builder()
                .id(form.getId() == null ? null : form.getId().toString())
                .name(form.getName())
                .description(form.getDescription())
                .active(form.isActive())
                .questions(getQuestionDtos(form.getQuestions()))
                .build();
    }

    private List<QuestionDto> getQuestionDtos(List<AbstractQuestion> questions) {
        return questions
                .stream()
                .map(question -> {
                    FreeTextQuestion freeTextQuestion = null;
                    RadioButtonQuestion radioButtonQuestion = null;

                    if (question instanceof FreeTextQuestion) {
                        freeTextQuestion = (FreeTextQuestion) question;
                    }

                    if (question instanceof RadioButtonQuestion) {
                        radioButtonQuestion = (RadioButtonQuestion) question;
                    }

                    return QuestionDto.builder()
                            .freeText(freeTextQuestion)
                            .radioButton(radioButtonQuestion)
                            .build();
                })
                .collect(Collectors.toList());
    }

    default FormDocument convertToFormDocument(Form form) {
        return FormDocument.builder()
                .id(form.getId() == null ? UUID.randomUUID() : form.getId())
                .name(form.getName())
                .description(form.getDescription())
                .active(form.isActive())
                .questions(form.getQuestions())
                .build();
    }

    Form convertToForm(FormDocument formDocument);

}
