package org.example.servicec_remake.security.service;

import org.example.servicec_remake.security.mapper.UserMapper;
import org.example.servicec_remake.security.model.AuthenticatedUser;
import org.example.servicec_remake.security.repository.UserDocument;
import org.example.servicec_remake.security.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    public LoginService(UserRepository userRepository, UserMapper userMapper, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    public AuthenticatedUser login(String userName, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password));

        String token = jwtTokenProvider.createToken(authentication);

        //todo builder
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDocument userDocument = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username));

        return userMapper.convertUserDocument(userDocument);
    }

}
