package org.example.servicec_remake.filledform.controller;


import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.filledform.controller.dto.FilledFormDto;
import org.example.servicec_remake.filledform.mapper.FilledFormMapper;
import org.example.servicec_remake.filledform.model.FilledForm;
import org.example.servicec_remake.filledform.service.FilledFormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/v1/filled-forms")
@RequiredArgsConstructor
public class FilledFormRestController {

    private final FilledFormService filledFormService;
    private final FilledFormMapper filledFormMapper;

    @PostMapping
    public ResponseEntity<FilledFormDto> createNewForm(@RequestBody FilledFormDto filledFormDto) {
        FilledForm savedFilledForm = filledFormService.save(filledFormMapper.convertToFilledForm(filledFormDto));
        FilledFormDto savedFilledFormDto = filledFormMapper.convertToFilledFormDto(savedFilledForm);

        URI uri = URI.create(String.format("/v1/filled-forms/%s", filledFormDto.getFormId()));
        return ResponseEntity.created(uri).body(savedFilledFormDto);
    }

    @GetMapping(path = "/{formId}")
    public ResponseEntity<FilledFormDto> getFormById(@PathVariable String formId) {
        FilledFormDto filledFormDto = filledFormMapper.convertToFilledFormDto(filledFormService.getById(formId));
        return ResponseEntity.ok(filledFormDto);
    }
}
