package com.liveFreely.Application.Controllers;
import com.liveFreely.Application.Exceptions.AuthenticationException;
import com.liveFreely.Application.Exceptions.LogoutException;
import com.liveFreely.Application.Exceptions.RegistrationException;
import com.liveFreely.Application.Services.LoginRequestSimply;
import com.liveFreely.Application.Services.RegistrationRequestSimply;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface AuthController {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequestSimply loginRequest) throws AuthenticationException;

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody RegistrationRequestSimply registrationRequest) throws RegistrationException;

    @PostMapping("/logout")
    ResponseEntity<?> logout(@RequestHeader("Authorization") String token);
}
