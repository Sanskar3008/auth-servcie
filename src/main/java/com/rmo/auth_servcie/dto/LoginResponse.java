package com.rmo.auth_servcie.dto;

import java.util.UUID;

public record LoginResponse(
        String token,
        UUID operatorId,
        UUID agentId,
        String role
) {}

