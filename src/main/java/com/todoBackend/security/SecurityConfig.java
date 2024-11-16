package com.todoBackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;



@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
    // Bean for configuring HTTP security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http.cors(Customizer.withDefaults() )
         .csrf().disable()  // Disable CSRF for API requests (not required for simple APIs)
            .authorizeRequests()
            .requestMatchers("/api/todos/**").authenticated()  // Protect your API endpoints
            .and()
            .httpBasic(); // Enable Basic Authentication
        return http.build();
    }

    // Define in-memory user details service for authentication
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder()
                .username("admin")  // Username: admin
                .password("admin123")  // Password: admin123
                .roles("USER")  // User role
                .build()
        );
    }

}
