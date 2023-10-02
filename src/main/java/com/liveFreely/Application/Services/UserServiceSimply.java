package com.liveFreely.Application.Services;

import com.liveFreely.Application.Entity.UserEntity;
import com.liveFreely.Application.Exceptions.RegistrationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceSimply implements UserService {

    private final List<UserEntity> users = new ArrayList<>();

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${app.jwt.validityInMilliseconds}")
    private long validityInMilliseconds;

    @Value("${app.jwt.secretKey}")
    private String secretKey;

    @Override
    public UserEntity registerUser(String username, String email, String password) throws RegistrationException {
        if (isUsernameExists(username) || isEmailExists(email)) {
            throw new RegistrationException("Username or email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);
        UserEntity newUser = new UserEntity(username, email, encodedPassword);
        users.add(newUser);
        return newUser;
    }


    @Override
    public UserEntity authenticate(String username, String password) {
        UserEntity user = getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        if (!passwordEncoder.matches(password, user.getEncodedPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return user;
    }

    @Override
    public String generateJwtToken(UserEntity authenticatedUser) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(authenticatedUser.getUsername())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @Override
    public boolean isUsernameExists(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public boolean isEmailExists(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public void createUser(UserEntity user) {
        users.add(user);
    }

    private UserEntity getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}