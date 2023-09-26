package ru.zifrkoks.delivery_service.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.zifrkoks.delivery_service.security.services.MainDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return 
        http
        .cors((cors)-> cors.disable())
        .csrf((cors)-> cors.disable())
        .authorizeHttpRequests((a)-> a.anyRequest().permitAll())
        .headers((auth)-> auth.frameOptions((f)->f.disable()))
        .build();
                
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MainDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
