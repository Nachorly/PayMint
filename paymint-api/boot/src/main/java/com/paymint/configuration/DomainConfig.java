package com.paymint.configuration;

import com.paymint.users.repositories.UserRepository;
import com.paymint.users.services.UserService;
import com.paymint.users.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserServiceImpl(userRepository);
    }
}
