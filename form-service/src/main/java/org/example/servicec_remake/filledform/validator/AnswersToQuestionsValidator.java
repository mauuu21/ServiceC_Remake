package org.example.servicec_remake.filledform.validator;


import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.filledform.model.AbstractAnswer;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.filledform.model.FreeTextAnswer;
import org.example.servicec_remake.filledform.model.RadioButtonAnswer;
import org.example.servicec_remake.form.model.AbstractQuestion;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.model.FreeTextQuestion;
import org.example.servicec_remake.form.model.RadioButtonQuestion;
import org.example.servicec_remake.form.service.FormService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
@RequiredArgsConstructor
public class AnswersToQuestionsValidator implements Validator {

    private final FormService formService;

    @Override
    public void validate(FilledForm filledForm) {
        Form emptyForm = formService.getById(filledForm.getFormId()).get();

        for (int i = 0; i < filledForm.getAnswers().size(); i++) {
            AbstractAnswer answer = filledForm.getAnswers().get(i);
            AbstractQuestion question = emptyForm.getQuestions().get(i);

            boolean ifRadioButtonAnswerThenRadioButtonQuestion =
                    answer instanceof RadioButtonAnswer && question instanceof RadioButtonQuestion;

            boolean ifFreeTextAnswerThenFreeTextQuestion =
                    answer instanceof FreeTextAnswer && question instanceof FreeTextQuestion;

            if (!ifRadioButtonAnswerThenRadioButtonQuestion && !ifFreeTextAnswerThenFreeTextQuestion) {
                throw new ValidationException("Answers must be in the same order as Questions");
            }
        }
    }
}
