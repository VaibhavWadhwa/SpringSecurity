package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class FiltersConfig {

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws  Exception{
        return http.authorizeHttpRequests(request ->
                request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()).csrf(c ->
                        c.disable()).build();
    }
}
