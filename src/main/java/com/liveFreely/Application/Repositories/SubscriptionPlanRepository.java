package com.liveFreely.Application.Repositories;

import com.liveFreely.Application.Entity.SubscriptionPlanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface  SubscriptionPlanRepository extends JpaRepository<SubscriptionPlanDTO, Long> {
    // Custom query method to find subscription plans by duration
    List<SubscriptionPlanDTO> findByDuration(int duration);

    // You can add more custom query methods here based on your requirements

    // Custom query method to find subscription plans by name
    List<SubscriptionPlanDTO> findByName(String name);

    // Custom query method to find subscription plans by price less than a certain value
    List<SubscriptionPlanDTO> findByPriceLessThan(double price);

    // Custom query method to find subscription plans by type
    List<SubscriptionPlanDTO> findByType(String type);

    // Custom query method to find subscription plans by isActive status
    List<SubscriptionPlanDTO> findByIsActive(boolean isActive);
}