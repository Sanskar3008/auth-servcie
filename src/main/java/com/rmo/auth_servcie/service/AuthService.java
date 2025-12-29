package com.rmo.auth_servcie.service;

import com.rmo.auth_servcie.dto.LoginRequest;
import com.rmo.auth_servcie.dto.LoginResponse;
import com.rmo.auth_servcie.dto.RegisterRequest;
import com.rmo.auth_servcie.entity.Agent;
import com.rmo.auth_servcie.entity.Operator;
import com.rmo.auth_servcie.repository.AgentRepository;
import com.rmo.auth_servcie.repository.OperatorRepository;
import com.rmo.auth_servcie.security.CustomUserDetails;
import com.rmo.auth_servcie.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    OperatorRepository operatorRepository;
    @Autowired
    AgentRepository agentRepository;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }



    public LoginResponse login(LoginRequest request) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));
        System.out.println("AUTH SUCCESS: " + auth.isAuthenticated());
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(user);

        return new LoginResponse(
                token,
                user.getOperatorId(),
                user.getAgentId(),
                user.getRole()
        );
    }
}
