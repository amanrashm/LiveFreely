package com.liveFreely.Application.Entity;

import javax.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user_profile_update_request") // Specify the table name explicitly
public class UserProfileUpdateRequest {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-increment IDs
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name") // Specify the column name explicitly
    private String name; // User's name (if updating)

    @Column(name = "email") // Specify the column name explicitly
    private String email; // User's email (if updating)

    // Constructors
    public UserProfileUpdateRequest() {
        // Default constructor
    }

    public UserProfileUpdateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserProfileUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Add getters and setters for additional fields if needed

    // You can also add more fields for updating profile information as needed
}