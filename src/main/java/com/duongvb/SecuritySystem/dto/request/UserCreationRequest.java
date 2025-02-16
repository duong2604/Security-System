package com.duongvb.SecuritySystem.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    @NotEmpty(message = "username is required.")
    private String username;

    @NotEmpty(message = "email is required.")
    private String email;

    @NotEmpty(message = "Password is required.")
    @Size(min = 8, max = 20, message = "Password must be at least 8 characters.")
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
