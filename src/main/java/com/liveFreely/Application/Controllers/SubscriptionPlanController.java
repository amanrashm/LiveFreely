package com.liveFreely.Application.Controllers;
import com.liveFreely.Application.Entity.SubscriptionPlanDTO;
import com.liveFreely.Application.Exceptions.PlanNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription-plans")
public interface SubscriptionPlanController {

    @GetMapping
    ResponseEntity<List< SubscriptionPlanDTO >> getAllSubscriptionPlans();

    @GetMapping("/{id}")
    ResponseEntity<SubscriptionPlanDTO> getSubscriptionPlanById(@PathVariable Long id) throws PlanNotFoundException;

    @PostMapping
    ResponseEntity<SubscriptionPlanDTO> createSubscriptionPlan(@RequestBody SubscriptionPlanDTO subscriptionPlanDTO);

    @PutMapping("/{id}")
    ResponseEntity<SubscriptionPlanDTO> updateSubscriptionPlan(@PathVariable Long id, @RequestBody SubscriptionPlanDTO subscriptionPlanDTO) throws PlanNotFoundException;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSubscriptionPlan(@PathVariable Long id) throws PlanNotFoundException;
}
