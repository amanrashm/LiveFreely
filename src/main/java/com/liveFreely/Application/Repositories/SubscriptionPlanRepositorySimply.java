package com.liveFreely.Application.Repositories;

import com.liveFreely.Application.Entity.SubscriptionPlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public abstract class SubscriptionPlanRepositorySimply implements SubscriptionPlanRepository {
    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SubscriptionPlanDTO> findByDuration(int duration) {
        TypedQuery<SubscriptionPlanDTO> query = entityManager.createQuery(
                "SELECT s FROM SubscriptionPlanDTO s WHERE s.duration = :duration",
                SubscriptionPlanDTO.class);
        query.setParameter("duration", duration);
        return query.getResultList();
    }

    @Override
    public List<SubscriptionPlanDTO> findByName(String name) {
        TypedQuery<SubscriptionPlanDTO> query = entityManager.createQuery(
                "SELECT s FROM SubscriptionPlanDTO s WHERE s.name = :name",
                SubscriptionPlanDTO.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<SubscriptionPlanDTO> findByPriceLessThan(double price) {
        TypedQuery<SubscriptionPlanDTO> query = entityManager.createQuery(
                "SELECT s FROM SubscriptionPlanDTO s WHERE s.price < :price",
                SubscriptionPlanDTO.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

   /* @Override
    public List<SubscriptionPlanDTO> findByType(String type) {
        TypedQuery<SubscriptionPlanDTO> query = entityManager.createQuery(
                "SELECT s FROM SubscriptionPlanDTO s WHERE s.type = :type",
                SubscriptionPlanDTO.class);
        query.setParameter("type", type);
        return query.getResultList();
    }*/

    @Override
    public List<SubscriptionPlanDTO> findByIsActive(boolean isActive) {
        TypedQuery<SubscriptionPlanDTO> query = entityManager.createQuery(
                "SELECT s FROM SubscriptionPlanDTO s WHERE s.isActive = :isActive",
                SubscriptionPlanDTO.class);
        query.setParameter("isActive", isActive);
        return query.getResultList();
    }
}