package com.rmo.auth_servcie.security;

import com.rmo.auth_servcie.entity.Operator;
import com.rmo.auth_servcie.repository.OperatorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final OperatorRepository operatorRepository;

    public CustomUserDetailsService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Operator operator = operatorRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
        return new CustomUserDetails(operator);
    }
}
