package com.duongvb.SecuritySystem.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    @NotEmpty(message = "INVALID_USERNAME")
    private String username;

    @NotEmpty(message = "INVALID_EMAIL")
    private String email;

    @NotEmpty(message = "INVALID_PASSWORD")
    @Size(min = 8, max = 20, message = "INVALID_PASSWORD")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
