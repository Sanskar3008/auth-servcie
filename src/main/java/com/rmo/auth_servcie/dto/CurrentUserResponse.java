package com.rmo.auth_servcie.dto;

import java.util.UUID;

public record CurrentUserResponse(
        UUID operatorId,
        UUID agentId,
        String username,
        String role
) {}