package com.rmo.auth_servcie.repository;

import com.rmo.auth_servcie.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OperatorRepository extends JpaRepository<Operator, UUID> {
    Optional<Operator> findByUsername(String username);
}

