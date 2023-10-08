package com.liveFreely.Application.Entity;


import javax.persistence.*;

@Entity
@Table(name = "user_entity") // Specify the table name explicitly
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-increment IDs
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email") // Specify the column name explicitly
    private String email;

    @Column(name = "username") // Specify the column name explicitly
    private String username; // Renamed to follow Java naming conventions

    @Column(name = "encoded_password") // Specify the column name explicitly
    private String encodedPassword;

    // Constructors
    public UserEntity() {
        // Default constructor
    }

    public UserEntity(String username, String email, String encodedPassword) {
        this.username = username;
        this.email = email;
        this.encodedPassword = encodedPassword;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public void setPassword(String encode) {
    }

    // You can add other properties, methods, and annotations as needed
}
