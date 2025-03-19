package com.exam.exam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exam.Model.JwtRequest;
import com.exam.exam.Model.JwtResponse;
import com.exam.exam.Model.User;
import com.exam.exam.Service.UserDetailsServiceImpl;
import com.exam.exam.config.jwtUtils;

@RestController
public class AuthenticateController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private jwtUtils jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
		authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		
		}catch(UsernameNotFoundException ex){
			throw new Exception("usernotfound"+ex.getMessage());
		}
		
		UserDetails  details=this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(details);
		return ResponseEntity.ok(new JwtResponse(token)); 
	}
	
	public void authenticate(String username,String password) throws Exception {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch(DisabledException ex) {
			throw new Exception("USer Disable"+ex.getMessage());
		}catch(BadCredentialsException ex) {
			throw new Exception("invalis credentails"+ex.getMessage());
		}
		
		
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
	
}
