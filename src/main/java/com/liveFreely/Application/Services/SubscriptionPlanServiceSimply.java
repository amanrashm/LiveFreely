package com.liveFreely.Application.Services;
import com.liveFreely.Application.Entity.SubscriptionPlanDTO;
import com.liveFreely.Application.Exceptions.PlanNotFoundException;
import com.liveFreely.Application.Repositories.SubscriptionPlanRepositorySimply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ComponentScan
public class SubscriptionPlanServiceSimply implements SubscriptionPlanService {

    private final SubscriptionPlanRepositorySimply subscriptionPlanRepository;

    @Autowired
    public SubscriptionPlanServiceSimply(SubscriptionPlanRepositorySimply subscriptionPlanRepository) {
        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }

    @Override
    public SubscriptionPlanDTO getPlanById(Long planId) throws PlanNotFoundException {
        Optional<SubscriptionPlanDTO> optionalPlan = subscriptionPlanRepository.findById(planId);

        if (optionalPlan.isPresent()) {
            return convertToDTO(optionalPlan.get());
        } else {
            throw new PlanNotFoundException("Plan with ID " + planId + " not found");
        }
    }

    @Override
    public List<SubscriptionPlanDTO> getAllPlans() {
        List<SubscriptionPlanDTO> allPlans = subscriptionPlanRepository.findAll();
        return allPlans.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionPlanDTO createPlan(SubscriptionPlanDTO subscriptionPlanDTO) {
        // Implement logic to create a new subscription plan
        SubscriptionPlanDTO createdPlan = subscriptionPlanRepository.save(subscriptionPlanDTO);
        return convertToDTO(createdPlan);
    }

    @Override
    public SubscriptionPlanDTO updatePlan(Long id, SubscriptionPlanDTO subscriptionPlanDTO) throws PlanNotFoundException {
        Optional<SubscriptionPlanDTO> optionalPlan = subscriptionPlanRepository.findById(id);

        if (optionalPlan.isPresent()) {
            // Update the existing plan with the new data
            SubscriptionPlanDTO existingPlan = optionalPlan.get();
            existingPlan.setName(subscriptionPlanDTO.getName());
            existingPlan.setDescription(subscriptionPlanDTO.getDescription());
            existingPlan.setPrice(subscriptionPlanDTO.getPrice());
            // Update other fields as needed

            // Save the updated plan
            SubscriptionPlanDTO updatedPlan = subscriptionPlanRepository.save(existingPlan);
            return convertToDTO(updatedPlan);
        } else {
            throw new PlanNotFoundException("Plan with ID " + id + " not found");
        }
    }

    @Override
    public boolean deletePlan(Long id) throws PlanNotFoundException {
        Optional<SubscriptionPlanDTO> optionalPlan = subscriptionPlanRepository.findById(id);

        if (optionalPlan.isPresent()) {
            // Plan found, delete it
            subscriptionPlanRepository.delete(optionalPlan.get());
            return true;
        } else {
            throw new PlanNotFoundException("Plan with ID " + id + " not found");
        }
    }

    // Helper method to convert a SubscriptionPlanDTO entity to a DTO
    private SubscriptionPlanDTO convertToDTO(SubscriptionPlanDTO subscriptionPlan) {
        if (subscriptionPlan == null) {
            return null; // Handle the case where the input is null
        }

        SubscriptionPlanDTO dto = new SubscriptionPlanDTO();
        dto.setId(subscriptionPlan.getId());
        dto.setName(subscriptionPlan.getName());
        dto.setDescription(subscriptionPlan.getDescription());
        dto.setPrice(subscriptionPlan.getPrice());
        // Set other DTO properties as needed
        return dto;
    }
}