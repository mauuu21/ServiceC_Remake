package org.example.servicec_remake.security.controller;


import jakarta.validation.Valid;
import org.example.servicec_remake.security.controller.dto.RegistrationRequest;
import org.example.servicec_remake.security.controller.dto.RegistrationResponse;
import org.example.servicec_remake.security.mapper.UserFactory;
import org.example.servicec_remake.security.model.User;
import org.example.servicec_remake.security.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1/registration")
public class RegistrationRestController {

    private final RegistrationService registrationService;
    private  final UserFactory userFactory;

    public RegistrationRestController(RegistrationService registrationService, UserFactory userFactory) {
        this.registrationService = registrationService;
        this.userFactory = userFactory;
    }

    @PostMapping
    public ResponseEntity<RegistrationResponse> register(@Valid @RequestBody RegistrationRequest registerUserRequest) {
    //TODO validate request

        User newUser = userFactory.create(registerUserRequest);

        User registeredUser = registrationService.register(newUser);

        return ResponseEntity.ok().body(RegistrationResponse.builder()
                .id(registeredUser.getId())
                .username(registeredUser.getUsername())
                .build());
    }

}

