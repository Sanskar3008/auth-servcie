package com.rmo.auth_servcie.security;

import com.rmo.auth_servcie.entity.Operator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class CustomUserDetails implements UserDetails {

    private final Operator operator;

    public CustomUserDetails(Operator operator) {
        this.operator = operator;
    }

    public UUID getOperatorId() {
        return operator.getId();
    }

    public UUID getAgentId() {
        return operator.getAgent().getId();
    }

    public String getRole() {
        return operator.getRole().name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + operator.getRole().name()));
    }

    @Override
    public String getPassword() {
        return operator.getPassword();
    }

    @Override
    public String getUsername() {
        return operator.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return operator.isActive();
    }


}

