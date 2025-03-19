package com.exam.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.exam.Service.UserDetailsServiceImpl;

import jakarta.annotation.security.PermitAll;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class MySecurityConfig{

	@Autowired
	private jwtAuthenticationEntryPoint unauthorizedHandler;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private jwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
		      .cors()
		      .disable()
		      .csrf()
		      .disable()
		      .authorizeHttpRequests()
		      .requestMatchers("/generate-token","/user","/category").permitAll()
		      .requestMatchers("/generate-token","/category").permitAll()
		      .requestMatchers("/generate-token","/category").permitAll()
		      .requestMatchers(HttpMethod.OPTIONS).permitAll()
		      .anyRequest().authenticated()
		      .and()
		      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		      .and()
		      .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	
	    public AuthenticationManager authManager(AuthenticationManagerBuilder auth) throws Exception {
	        return (AuthenticationManager) auth
	                .userDetailsService(this.userDetailsServiceImpl)
	                .passwordEncoder(passwordEncoder());
	                
	    }

	  @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	    }
	

}
