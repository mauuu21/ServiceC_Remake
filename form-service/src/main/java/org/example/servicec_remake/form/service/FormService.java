package org.example.servicec_remake.form.service;

import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.form.mapper.FormMapper;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.repository.FormDocument;
import org.example.servicec_remake.form.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FormService {

    public final FormRepository formRepository;
    public final FormMapper formMapper;

    public Form save(Form form) {
        FormDocument newFormDocument = formMapper.convertToFormDocument(form);
        FormDocument savedFormDocument = formRepository.save(newFormDocument);

        return formMapper.convertToForm(savedFormDocument);
    }

    public Optional<Form> getById(UUID id) {
        return formRepository
                .findById(id)
                .map(formMapper::convertToForm);
    }
}
