package com.liveFreely.Application.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_login_request") // Specify the table name explicitly
public class UserLoginRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-increment IDs
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username") // Specify the column name explicitly
    private String username; // User's username or email

    @Column(name = "password") // Specify the column name explicitly
    private String password; // User's password

    // Constructors
    public UserLoginRequest() {
        // Default constructor
    }

    public UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // You can add other properties, methods, and annotations as needed
}