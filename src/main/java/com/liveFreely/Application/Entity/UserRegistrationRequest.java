package com.liveFreely.Application.Entity;


import javax.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user_registration_requests") // Specify the table name
public class UserRegistrationRequest {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-incremented IDs
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false) // Specify column attributes
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    // Constructors
    public UserRegistrationRequest() {
    }

    public UserRegistrationRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
