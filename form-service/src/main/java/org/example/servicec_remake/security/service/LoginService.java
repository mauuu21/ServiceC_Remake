package org.example.servicec_remake.security.service;

import lombok.AllArgsConstructor;
import org.example.servicec_remake.security.mapper.UserMapper;
import org.example.servicec_remake.security.model.AuthenticatedUser;
import org.example.servicec_remake.security.model.User;
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
@AllArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticatedUser login(String userName, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password));

        String token = jwtTokenProvider.createToken(authentication);

        User user = (User) authentication.getPrincipal();


        return AuthenticatedUser.builder()
                .user(user)
                .token(token)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDocument userDocument = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username));

        return userMapper.convertUserDocument(userDocument);
    }

}
