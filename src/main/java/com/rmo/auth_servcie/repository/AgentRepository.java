package com.rmo.auth_servcie.repository;

import com.rmo.auth_servcie.entity.Agent;
import com.rmo.auth_servcie.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AgentRepository extends JpaRepository<Agent, UUID> {
    Optional<Operator> findByAgentCode(String username);
}

