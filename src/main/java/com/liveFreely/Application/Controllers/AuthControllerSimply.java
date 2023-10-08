package com.liveFreely.Application.Controllers;

import com.liveFreely.Application.Entity.UserEntity;
import com.liveFreely.Application.Services.LoginRequestSimply;
import com.liveFreely.Application.Services.RegistrationRequestSimply;
import com.liveFreely.Application.Services.UserServiceSimply;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthControllerSimply implements AuthController {


    @Autowired
    private UserServiceSimply userService;

    @Autowired
    private  AuthControllerSimplyBuilder passwordEncoder;

    // Define the secret key variable
    @Value("${app.jwt.secretKey}")
    private final String secretKey;
    public AuthControllerSimply() {
        // Generate the secret key using AES algorithm
        SecretKey generatedSecretKey;
        try {
            generatedSecretKey = generateSecretKey();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if the algorithm is not available
            generatedSecretKey = null; // Set to null in case of an error
            e.printStackTrace();
        }

        // Convert the generated secret key to a Base64-encoded string
        assert generatedSecretKey != null;
        this.secretKey = Base64.getEncoder().encodeToString(generatedSecretKey.getEncoded());
    }

    // Rest of your AuthControllerSimply class remains unchanged...

    // Method to generate a secret key
    private SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES"); // You can choose a different algorithm (e.g., "AES", "DES", "HmacSHA256")
        return keyGen.generateKey();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestSimply loginRequest) {
        try {
            // Validate user credentials and authenticate
            UserEntity authenticatedUser = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

            // Generate a JWT token
            String jwtToken = generateJwtToken(authenticatedUser);

            // Return the token in the response
            Map<String, String> response = new HashMap<>();
            response.put("token", jwtToken);
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException e) {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Authentication failed"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequestSimply registrationRequest) {
        // Check if the username or email already exists
        if (userService.isUsernameExists(registrationRequest.getUsername())) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Username already exists"));
        }
        if (userService.isEmailExists(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Email already exists"));
        }

        // Create a new user account based on registration data
        UserEntity newUser = new UserEntity();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setEmail(registrationRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        // Save the user in the database
        userService.createUser(newUser);

        // Generate a JWT token for the newly registered user (optional)
        String jwtToken = generateJwtToken(newUser);

        // Return the new user's details and token (optional)
        Map<String, Object> response = new HashMap<>();
        response.put("user", newUser);
        if (jwtToken != null) {
            response.put("token", jwtToken);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        try {
            // Validate and decode the JWT token
            Claims claims = validateAndDecodeJwtToken(token);

            // Perform the logout action if needed
            // For example, you can maintain a list of invalidated tokens on the server-side

            // For simplicity, let's assume we invalidate the token on the server-side
            // You should implement a proper token invalidation mechanism
            // Typically, you would store invalidated tokens in a database or cache

            // Here, we simulate token invalidation by removing it from a list
            boolean tokenInvalidated = invalidateToken(claims);

            if (tokenInvalidated) {
                // Return a 204 No Content response on successful logout
                return ResponseEntity.noContent().build();
            } else {
                // Handle logout failure (token not found or already invalidated)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Logout failed"));
            }
        } catch (Exception e) {
            // Handle any exceptions during token validation or logout
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Logout failed"));
        }
    }

    private Claims validateAndDecodeJwtToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private final Set<String> invalidatedTokens = new HashSet<>();

    private boolean invalidateToken(Claims claims) {
        // Extract the token's unique identifier (assuming you include it when generating the token)
        String tokenId = claims.getId();

        // Check if the token's ID is in the set of invalidated tokens
        // Token is invalidated
        // Token is not invalidated
        return invalidatedTokens.contains(tokenId);
    }


    // Method to generate a JWT token
    private String generateJwtToken(UserEntity user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}