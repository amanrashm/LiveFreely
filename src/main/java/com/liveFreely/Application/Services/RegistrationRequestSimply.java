package com.liveFreely.Application.Services;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class RegistrationRequestSimply implements RegistrationRequest {

    private String username;
    private String email;
    private String password;

    // Constructor
    public RegistrationRequestSimply(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // You can include setter methods if needed to set these values
    // Add any other fields and methods that are required for registration data
}
