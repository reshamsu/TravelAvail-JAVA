package com.travelavail.travelsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for testing (not recommended in production)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/user/add", "/user/getAll").permitAll() // These APIs are publicly accessible
                                .anyRequest().permitAll() // Permit all other requests for now (for debugging)
                )
                .formLogin(login -> login.disable()) // Disable default login form
                .httpBasic(basic -> basic.disable()); // Disable basic authentication

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
