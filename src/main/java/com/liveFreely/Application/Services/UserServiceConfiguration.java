package com.liveFreely.Application.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfiguration {

    @Bean
    public UserServiceSimply userServiceSimply() {
        return new UserServiceSimply();
    }
}
