package com.liveFreely.Application.Services;

import com.liveFreely.Application.Entity.UserEntity;
import com.liveFreely.Application.Exceptions.RegistrationException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * Registers a new user with the given username, email, and password.
     *
     * @param username The username of the new user.
     * @param email    The email of the new user.
     * @param password The password of the new user.
     * @return The newly registered user.
     * @throws RegistrationException If registration fails due to username or email conflicts.
     */
    UserEntity registerUser(String username, String email, String password) throws RegistrationException;

    /**
     * Authenticates a user by verifying the provided username and password.
     *
     * @param username The username of the user to authenticate.
     * @param password The password to verify.
     * @return The authenticated user entity.
     */
    UserEntity authenticate(String username, String password);

    /**
     * Generates a JWT token for an authenticated user.
     *
     * @param authenticatedUser The authenticated user entity.
     * @return The JWT token as a string.
     */
    String generateJwtToken(UserEntity authenticatedUser);

    /**
     * Checks if a user with the given username already exists.
     *
     * @param username The username to check.
     * @return {@code true} if a user with the username exists, {@code false} otherwise.
     */
    boolean isUsernameExists(String username);

    /**
     * Checks if a user with the given email already exists.
     *
     * @param email The email to check.
     * @return {@code true} if a user with the email exists, {@code false} otherwise.
     */
    boolean isEmailExists(String email);

    /**
     * Creates a new user.
     *
     * @param newUser The user entity to create.
     */
    void createUser(UserEntity newUser);
}
