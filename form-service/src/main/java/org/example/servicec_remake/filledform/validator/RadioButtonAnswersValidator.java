package org.example.servicec_remake.filledform.validator;


import lombok.RequiredArgsConstructor;
import jakarta.xml.bind.ValidationException;
import org.example.servicec_remake.filledform.model.AbstractAnswer;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.filledform.model.RadioButtonAnswer;
import org.example.servicec_remake.form.model.AbstractQuestion;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.model.RadioButtonQuestion;
import org.example.servicec_remake.form.service.FormService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Order(4)
@Component
@RequiredArgsConstructor
public class RadioButtonAnswersValidator implements Validator {

    private final FormService formService;

    @Override
    public void validate(FilledForm filledForm) throws ValidationException {
        Form emptyForm = formService.getById(filledForm.getFormId()).get();

        for (int i = 0; i < filledForm.getAnswers().size(); i++) {
            AbstractAnswer answer = filledForm.getAnswers().get(i);
            AbstractQuestion question = emptyForm.getQuestions().get(i);

            //new way of instanceof
            if (answer instanceof RadioButtonAnswer radioButtonAnswer) {
                RadioButtonQuestion radioButtonQuestion = (RadioButtonQuestion) question;

                if (!radioButtonQuestion.getOptions().contains(radioButtonAnswer.getAnswer())) {
                    throw new ValidationException("Given answer was not an option for question " + radioButtonQuestion.getQuestion());
                }
            }
        }


    }
}
