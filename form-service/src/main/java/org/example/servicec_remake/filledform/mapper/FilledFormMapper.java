package org.example.servicec_remake.filledform.mapper;


import org.example.servicec_remake.filledform.controller.dto.AnswerDto;
import org.example.servicec_remake.filledform.controller.dto.FilledFormDto;
import org.example.servicec_remake.filledform.model.AbstractAnswer;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.filledform.model.FreeTextAnswer;
import org.example.servicec_remake.filledform.model.RadioButtonAnswer;
import org.example.servicec_remake.filledform.repository.FilledFormDocument;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface FilledFormMapper {

    FilledFormDocument convertToFilledFormDocument(FilledForm filledForm);

    FilledForm convertToFilledForm(FilledFormDocument filledFormDocument);

    default FilledFormDto convertToFilledFormDto(FilledForm filledForm) {
        return FilledFormDto.builder()
                .id(filledForm.getId())
                .formId(filledForm.getFormId())
                .answers(this.convertToDto(filledForm.getAnswers()))
                .build();
    }

    private List<AnswerDto> convertToDto(List<AbstractAnswer> answers) {
        return answers.stream()
                .map(abstractAnswer -> {
                    FreeTextAnswer freeText = null;
                    RadioButtonAnswer radioButton = null;

                    if (abstractAnswer instanceof FreeTextAnswer) {
                        freeText = (FreeTextAnswer) abstractAnswer;

                    } else if (abstractAnswer instanceof RadioButtonAnswer) {
                        radioButton = (RadioButtonAnswer) abstractAnswer;

                    }

                    return new AnswerDto(freeText, radioButton);
                })
                .collect(Collectors.toList());
    }

    default FilledForm convertToFilledForm(FilledFormDto filledFormDto) {
        return FilledForm.builder()
                .id(filledFormDto.getId())
                .formId(filledFormDto.getFormId())
                .answers(convertFromDto(filledFormDto.getAnswers()))
                .build();
    }

    private List<AbstractAnswer> convertFromDto(List<AnswerDto> answers) {
        return answers.stream()
                .map(AnswerDto::getNotNullValue)
                .collect(Collectors.toList());
    }

}
