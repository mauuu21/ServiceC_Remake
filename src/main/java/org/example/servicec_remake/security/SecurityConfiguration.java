package org.example.servicec_remake.security;

import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.example.servicec_remake.security.model.Role;
import org.example.servicec_remake.security.service.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManagerBean();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(
                authorization ->
                        authorization
                            .requestMatchers("/v1/login").permitAll()
                            .requestMatchers("/v1/registration").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin ->
                        formLogin.loginPage("/v1/login")
        ).logout(
                logout ->
                        logout.logoutSuccessUrl("").permitAll()
        );

        return httpSecurity.build();
    }
}
