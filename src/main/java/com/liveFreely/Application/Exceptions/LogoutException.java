package com.liveFreely.Application.Exceptions;

public class LogoutException extends Exception {

    public LogoutException(String message) {
        super(message);
    }

    // You can add additional constructors or methods as needed
}
// throw new LogoutException("Error occurred during logout");