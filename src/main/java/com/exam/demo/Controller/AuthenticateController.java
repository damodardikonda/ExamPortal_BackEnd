package com.exam.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.demo.Config.JwtUtils;
import com.exam.demo.Entity.JwtRequest;
import com.exam.demo.Entity.JwtResponse;
import com.exam.demo.Entity.User;
import com.exam.demo.Services.ServiceCls.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*") // If we delete this then i will get CORS Error and * for all host
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private UserDetailsServiceImpl userdetailsserviceimpl;
	
	@Autowired
	private JwtUtils jwtutils;
	
	private void authenticate(String username , String password) throws Exception{
		
		try {
			authenticationmanager.authenticate( new UsernamePasswordAuthenticationToken(username , password));
			
		}catch(DisabledException e) {
			throw new Exception(" User is desabled");
		}catch(BadCredentialsException d) {
			throw new Exception("Bad credential ");
		}
	}
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception{
		
		try {
			
			authenticate(jwtrequest.getUsername() , jwtrequest.getPassword());
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception(" User not found");
		}
		
		////authenticate
		UserDetails userdetails = this.userdetailsserviceimpl.loadUserByUsername(jwtrequest.getUsername());
		String token = this.jwtutils.generateToken(userdetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	// for getting curent user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User) this.userdetailsserviceimpl.loadUserByUsername(principal.getName()));
	}
	
}
