package com.rmo.auth_servcie.dto;



import java.util.UUID;

public class RegisterRequest {
    private String username;
    private String password;
    private String role; // e.g., MANAGER, OPERATOR, CUSTOM
    private String agentId;

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String  getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }
}
