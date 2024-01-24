package org.example.servicec_remake.filledform.validator;


import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FilledFormValidatorAggregator {

    private final List<Validator> validators;

    public void validate(FilledForm filledForm) {
        validators.forEach(validator -> {
            try {
                validator.validate(filledForm);
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
