package com.exam.exam.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.query.EqlParser.New_valueContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.exam.Service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private jwtUtils jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    String  requestTokenHeader = request.getHeader("Authorization");
	System.out.print(requestTokenHeader+"hii");
	String username= null;
	String jwtToken=null;
	
	if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
		
		jwtToken=requestTokenHeader.substring(7);
		System.out.print(jwtToken);
		try {
			username=this.jwtUtil.extractUsername(jwtToken);
			
		}catch(ExpiredJwtException ex) {
			ex.printStackTrace();
			System.out.print("jwt token expired");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.print("error");
			
		}
		
	}else {
		System.out.print("invalid token username not found!!");
	}
	if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		
		
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
		if(this.jwtUtil.validateToken(jwtToken, userDetails)){
		UsernamePasswordAuthenticationToken authentications = 
		        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		//authentications.setDetails(new WebAuthenticationDetailsSource.buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentications);
	}
	
	}else {
		System.out.print("token is invalid");
	}
		filterChain.doFilter(request, response);
	}

}
