package com.liveFreely.Application.Repositories;

import com.liveFreely.Application.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username); // Corrected method name to findByUsername

    UserEntity findByEmail(String email); // Corrected parameter name to email
}
