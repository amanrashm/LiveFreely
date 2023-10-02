package com.liveFreely.Application.Services;

import com.liveFreely.Application.Exceptions.UserEmailNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface CustomUserDetailsService {

    UserDetails loadUserByUsername (String username) throws UsernameNotFoundException;

    UserDetails loadUserByUserEmail (String email) throws UserEmailNotFoundException;
}