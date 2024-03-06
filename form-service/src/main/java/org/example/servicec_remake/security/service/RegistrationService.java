package org.example.servicec_remake.security.service;

import org.example.servicec_remake.security.mapper.UserMapper;
import org.example.servicec_remake.security.model.User;
import org.example.servicec_remake.security.repository.UserDocument;
import org.example.servicec_remake.security.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public RegistrationService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User register(User newUser) {

        UserDocument  newUserDocument = userMapper.convertUserToUserDocument(newUser);
        UserDocument savedUserDocument = userRepository.save(newUserDocument);

        return userMapper.convertUserDocument(savedUserDocument);
    }
}
