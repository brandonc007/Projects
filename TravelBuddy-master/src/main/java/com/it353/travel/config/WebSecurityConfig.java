package com.it353.travel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.it353.travel.service.CustomUserDetailsService;

	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig {

	    @Bean
	    public UserDetailsService userDetailsService() {
	        return new CustomUserDetailsService();
	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());

	        return authProvider;
	    }

	    
	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        
	        http
	        .authorizeHttpRequests((authorize) -> authorize
	            .requestMatchers("/users").authenticated()
	            .anyRequest().permitAll()
	        )
	        .formLogin(form -> form
	            .loginProcessingUrl("/userLogin") // Specify the URL to submit the username and password.
	            .usernameParameter("email")
	            .defaultSuccessUrl("/users", true)
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .logoutSuccessUrl("/")
	            .permitAll()
	        );

	    return http.build();
	}
	}

