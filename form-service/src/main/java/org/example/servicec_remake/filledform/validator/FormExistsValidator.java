package org.example.servicec_remake.filledform.validator;




import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.form.service.FormService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Order(1)
@Component
@RequiredArgsConstructor
public class FormExistsValidator implements Validator {

    private final FormService formService;

    @Override
    public void validate(FilledForm filledForm) throws ValidationException {
        formService
                .getById(filledForm.getFormId())
                .orElseThrow(() -> new ValidationException("Form does not exist"));

    }
}
