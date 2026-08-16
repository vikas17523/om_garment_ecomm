package com.ecommerce.api.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.api.entity.UserRegistration;
import com.ecommerce.api.repository.UserRegistraionRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRegistraionRepository userRepository;

    public CustomUserDetailsService(
            UserRegistraionRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserRegistration user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
