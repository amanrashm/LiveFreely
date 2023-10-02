package com.liveFreely.Application.Services;
import com.liveFreely.Application.Entity.SubscriptionPlanDTO;
import com.liveFreely.Application.Exceptions.PlanNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionPlanService {

    // Retrieve a subscription plan by its ID
    SubscriptionPlanDTO getPlanById(Long planId) throws PlanNotFoundException;

    // Retrieve a list of all available subscription plans
    List <SubscriptionPlanDTO> getAllPlans();

    SubscriptionPlanDTO createPlan(SubscriptionPlanDTO subscriptionPlanDTO);

    SubscriptionPlanDTO updatePlan(Long id, SubscriptionPlanDTO subscriptionPlanDTO) throws PlanNotFoundException;

    boolean deletePlan(Long id) throws PlanNotFoundException;

    // Add methods for creating, updating, and deleting subscription plans if needed
}
