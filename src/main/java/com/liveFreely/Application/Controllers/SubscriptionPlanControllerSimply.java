package com.liveFreely.Application.Controllers;

import com.liveFreely.Application.Entity.SubscriptionPlanDTO;
import com.liveFreely.Application.Exceptions.PlanNotFoundException;
import com.liveFreely.Application.Services.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RequestMapping("/subscription-plans")
public class SubscriptionPlanControllerSimply implements SubscriptionPlanController {

    @Autowired
    private final SubscriptionPlanService subscriptionPlanService;

    @Autowired
    public SubscriptionPlanControllerSimply(SubscriptionPlanService subscriptionPlanService) {
        this.subscriptionPlanService = subscriptionPlanService;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDTO>> getAllSubscriptionPlans() {
        List<SubscriptionPlanDTO> subscriptionPlans = subscriptionPlanService.getAllPlans();
        return new ResponseEntity<>(subscriptionPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlanDTO> getSubscriptionPlanById(@PathVariable Long id) throws PlanNotFoundException {
        SubscriptionPlanDTO subscriptionPlan = subscriptionPlanService.getPlanById(id);
        if (subscriptionPlan != null) {
            return new ResponseEntity<>(subscriptionPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SubscriptionPlanDTO> createSubscriptionPlan(@RequestBody SubscriptionPlanDTO subscriptionPlanDTO) {
        SubscriptionPlanDTO createdPlan = subscriptionPlanService.createPlan(subscriptionPlanDTO);
        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionPlanDTO> updateSubscriptionPlan(
            @PathVariable Long id,
            @RequestBody SubscriptionPlanDTO subscriptionPlanDTO) throws PlanNotFoundException {
        SubscriptionPlanDTO updatedPlan = subscriptionPlanService.updatePlan(id, subscriptionPlanDTO);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscriptionPlan(@PathVariable Long id) throws PlanNotFoundException {
        boolean deleted = subscriptionPlanService.deletePlan(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
