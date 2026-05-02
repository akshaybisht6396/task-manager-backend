package com.railways.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for REST APIs
            .authorizeHttpRequests(auth -> auth
                // 1. Explicitly open access to frontend files using exact Ant matching
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/index.html")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/static/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/*.html")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/*.css")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/*.js")).permitAll()
                
                // 2. IMPORTANT: Add Error endpoint permission to prevent 403 on routing/exceptions
                .requestMatchers(new AntPathRequestMatcher("/error")).permitAll()
                
                // 3. Open access to auth endpoints
                .requestMatchers(new AntPathRequestMatcher("/api/auth/**")).permitAll()
                
                // Protect everything else
                .anyRequest().authenticated()
            );
            
        return http.build();
    }
}