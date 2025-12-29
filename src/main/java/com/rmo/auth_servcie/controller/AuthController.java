package com.rmo.auth_servcie.controller;

import com.rmo.auth_servcie.dto.CurrentUserResponse;
import com.rmo.auth_servcie.dto.LoginRequest;
import com.rmo.auth_servcie.dto.LoginResponse;
import com.rmo.auth_servcie.dto.RegisterRequest;
import com.rmo.auth_servcie.entity.Operator;
import com.rmo.auth_servcie.security.CustomUserDetails;
import com.rmo.auth_servcie.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/me")
    public CurrentUserResponse me(Authentication authentication) {

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        return new CurrentUserResponse(
                user.getOperatorId(),
                user.getAgentId(),
                user.getUsername(),
                user.getRole()
        );
    }



}
