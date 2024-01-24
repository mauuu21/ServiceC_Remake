package org.example.servicec_remake.filledform.validator;


import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.service.FormService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Order(2)
@Component
@RequiredArgsConstructor
public class NumberOfAnswersValidator implements Validator {

    private final FormService formService;

    @Override
    public void validate(FilledForm filledForm) throws ValidationException {
        Form emptyForm = formService.getById(filledForm.getFormId()).get();

        if (filledForm.getAnswers().size() != emptyForm.getQuestions().size()) {
            throw new ValidationException("Number of answers and Number of questions must be same");
        }
    }
}
