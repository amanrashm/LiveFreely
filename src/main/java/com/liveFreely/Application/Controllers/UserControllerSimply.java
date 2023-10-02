package com.liveFreely.Application.Controllers;

import com.liveFreely.Application.Entity.UserLoginRequest;
import com.liveFreely.Application.Entity.UserProfileUpdateRequest;
import com.liveFreely.Application.Entity.UserRegistrationRequest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
@ComponentScan
public class UserControllerSimply implements UserController{
    @Override
    public ResponseEntity < ? > registerUser (UserRegistrationRequest registrationRequest) {
        return null;
    }

    @Override
    public ResponseEntity < ? > loginUser (UserLoginRequest loginRequest) {
        return null;
    }

    @Override
    public ResponseEntity < ? > getUserProfile (Long userId) {
        return null;
    }

    @Override
    public ResponseEntity < ? > updateUserProfile (Long userId, UserProfileUpdateRequest updateRequest) {
        return null;
    }

    @Override
    public ResponseEntity < ? > logoutUser ( ) {
        return null;
    }
}
