package org.example.servicec_remake.form.controller;

import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.form.controller.dto.FormDto;
import org.example.servicec_remake.form.mapper.FormMapper;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path = "/v1/forms")
@RequiredArgsConstructor
public class FormRestController {

    private final FormService formService;
    private final FormMapper formMapper;

    @PostMapping
    public ResponseEntity<FormDto> createNewForm(FormDto formDto) {

        Form savedForm = formService.save(formMapper.convertToForm(formDto));
        FormDto savedFormDto = formMapper.convertToFormDto(savedForm);

        URI uri = URI.create("/v1/forms" + savedFormDto.getId());
        return ResponseEntity.created(uri).body(savedFormDto);
    }
}
