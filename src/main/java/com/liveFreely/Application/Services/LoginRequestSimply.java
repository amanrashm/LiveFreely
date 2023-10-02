package com.liveFreely.Application.Services;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class LoginRequestSimply implements LoginRequest {
    private String username;
    private String password;

    // Constructor
    public LoginRequestSimply(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
