package org.example.servicec_remake.filledform.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.servicec_remake.filledform.model.AbstractAnswer;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.filledform.model.FreeTextAnswer;
import org.example.servicec_remake.filledform.validator.FilledFormValidatorAggregator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilledFormProcessor {
    private final FilledFormValidatorAggregator filledFormValidatorAggregator;
    private final FilledFormService filledFormService;

    public FilledForm save(FilledForm filledForm) {
        filledFormValidatorAggregator.validate(filledForm);
        log.info("Filled Form has been validated for {}", filledForm.getFormId());

        modifyFreeTextAnswersByModeration(filledForm.getAnswers());
        log.info("Filled Form has been moderated for {}", filledForm.getFormId());

        FilledForm savedFilledForm = filledFormService.save(filledForm);
        log.info("Filled Form has been saved of {}", savedFilledForm.getId());

        return savedFilledForm;
    }

    private void modifyFreeTextAnswersByModeration(List<AbstractAnswer> answers) {
        //TODO
    }

}
