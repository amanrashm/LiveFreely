package com.liveFreely.Application.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subscription_plan") // Specify the table name if it's different from the class name
public class SubscriptionPlanDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-increment IDs
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "price")
    private Double price;

    @Column(name = "subscription_plan") // Renamed the variable to follow conventions
    private Double subscriptionPlan; // Use Double for a decimal value

    @Column(name = "duration")
    private int duration;

    @Column(name = "description")
    private String description;

    // Other properties
    private String type;

    // Getter and setter for 'type'
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Default constructor (required by JPA)
    public SubscriptionPlanDTO() {
    }

    // Constructor with parameters
    public SubscriptionPlanDTO(Long id, String name, Boolean isActive, Double price, Double subscriptionPlan, int duration, String description) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.price = price;
        this.subscriptionPlan = subscriptionPlan;
        this.duration = duration;
        this.description = description;
        this.type = type;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(Double subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SubscriptionPlanDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", price=" + price +
                ", subscriptionPlan=" + subscriptionPlan +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }
}