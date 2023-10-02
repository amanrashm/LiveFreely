package com.liveFreely.Application.Exceptions;

public class AuthenticationException extends Exception {

    public AuthenticationException(String message) {
        super(message);
    }

    // You can add additional constructors or methods as needed
}
// throw new AuthenticationException("Invalid username or password");