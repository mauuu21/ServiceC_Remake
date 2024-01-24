package org.example.servicec_remake.filledform.validator;



import jakarta.xml.bind.ValidationException;
import org.example.servicec_remake.filledform.model.FilledForm;



public interface Validator {

    void validate(FilledForm filledForm) throws ValidationException;
}
