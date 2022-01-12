package com.exam.demo.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userdetailservice;
	
	@Autowired
	private JWTAuthenticationFilter jwtauthenticationfilter;
	
	@Autowired
	private JwtUtils jwtutil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String requestTokenHeader = request.getHeader( "Authorization");
		// requestTokenHeader will get token header
		System.out.println("header name = " + request.getHeaderNames());
		System.out.println("requesttokenheder = " +requestTokenHeader);
		String username = null;
		String jwtToken = null;
		//System.out.println("requestTokenbheader = " + username);
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = this.jwtutil.extractUsername(jwtToken);
			}catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println(" Jwt token has Expired ");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		}else {
			System.out.println(" Invalid Token ");
		}
	if( username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
		
		final UserDetails userdetail = this.userdetailservice.loadUserByUsername(username);
		
		if(this.jwtutil.validateToken(jwtToken , userdetail)) {
			UsernamePasswordAuthenticationToken usernamepasswordauthentication = new UsernamePasswordAuthenticationToken(userdetail ,null , userdetail.getAuthorities());
			usernamepasswordauthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthentication); 
			
		}
	}else {
		
		System.out.println(" Token is not working properly ");
	}
		
		filterChain.doFilter(request , response);
		// it is just forwarding the request 
	}

}
