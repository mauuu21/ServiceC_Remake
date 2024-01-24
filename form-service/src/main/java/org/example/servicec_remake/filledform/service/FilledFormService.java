package org.example.servicec_remake.filledform.service;


import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.filledform.mapper.FilledFormMapper;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.filledform.repository.FilledFormDocument;
import org.example.servicec_remake.filledform.repository.FilledFormRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilledFormService {
    private final FilledFormRepository filledFormRepository;
    private final FilledFormMapper filledFormMapper;

    public FilledForm save(FilledForm filledForm) {
        FilledFormDocument newFilledFormDocument = filledFormMapper.convertToFilledFormDocument(filledForm);
        FilledFormDocument savedFilledFormDocument = filledFormRepository.save(newFilledFormDocument);
        return filledFormMapper.convertToFilledForm(savedFilledFormDocument);
    }

    public FilledForm getById(String id) {
        return filledFormMapper
                .convertToFilledForm(filledFormRepository
                        .findById(UUID.fromString(id))
                        .orElseThrow(() -> new RuntimeException(String.format("Data not found by id %s", id)))
                );
    }

}
