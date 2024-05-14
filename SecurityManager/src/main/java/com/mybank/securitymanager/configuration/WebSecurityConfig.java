package com.mybank.securitymanager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

    @Autowired
    PasswordEncoder encoder;

    @Bean
    UserDetailsService customUserDetailsService() {
        UserDetails user = User
                .withUsername("mounir")
                .password(encoder.encode("12345"))
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        return manager;
    }


    @Bean
    WebSecurityCustomizer customizer() {
        return (web) -> {
            web.ignoring()
                    .requestMatchers("/", "/index");
        };
    }


}
