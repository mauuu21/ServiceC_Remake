package org.example.servicec_remake.security.service;

import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.security.mapper.UserMapper;
import org.example.servicec_remake.security.repository.UserDocument;
import org.example.servicec_remake.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserDocument userDocument = userRepository.findByUsername(username).orElseThrow(
                    () -> new UsernameNotFoundException(username));

            return userMapper.convertUserDocument(userDocument);
        }
    }

