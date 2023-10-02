package com.liveFreely.Application.Controllers;

import com.liveFreely.Application.Entity.UserLoginRequest;
import com.liveFreely.Application.Entity.UserProfileUpdateRequest;
import com.liveFreely.Application.Entity.UserRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public interface UserController {

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest registrationRequest);

    @PostMapping("/login")
    ResponseEntity<?> loginUser(@RequestBody UserLoginRequest loginRequest);

    @GetMapping("/{userId}")
    ResponseEntity<?> getUserProfile(@PathVariable Long userId);

    @PutMapping("/{userId}")
    ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileUpdateRequest updateRequest);

    @PostMapping("/logout")
    ResponseEntity<?> logoutUser();

    // Define other user-related endpoints as needed
}
