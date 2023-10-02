package com.liveFreely.Application.Services;

import com.liveFreely.Application.Entity.UserEntity;
import com.liveFreely.Application.Exceptions.UserEmailNotFoundException;
import com.liveFreely.Application.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    public UserRepository userRepository;


    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user data from your database using the UserRepository
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Create a UserDetails object based on the userEntity data
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getEncodedPassword()) // Should be the hashed password
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
                .build();
    }



    public UserDetails loadUserByUserEmail (String email) throws UserEmailNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UserEmailNotFoundException("User not found with email: " + email);
        }

        // Create a UserDetails object based on the userEntity data
        return User.withUsername(Objects.requireNonNull(userEntity).getUsername())
                .password(userEntity.getEncodedPassword()) // Should be the hashed password
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
                .build();
    }
}