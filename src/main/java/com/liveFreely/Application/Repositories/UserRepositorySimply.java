package com.liveFreely.Application.Repositories;

import com.liveFreely.Application.Entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public abstract class UserRepositorySimply implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity findByUsername(String username) {
        try {
            TypedQuery<UserEntity> query = entityManager.createQuery(
                    "SELECT u FROM UserEntity u WHERE u.username = :username",
                    UserEntity.class
            );
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Handle the case where no user with the given username is found
            return null;
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        try {
            TypedQuery<UserEntity> query = entityManager.createQuery(
                    "SELECT u FROM UserEntity u WHERE u.email = :email",
                    UserEntity.class
            );
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Handle the case where no user with the given email is found
            return null;
        }
    }
}
