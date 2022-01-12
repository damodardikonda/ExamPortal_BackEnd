package com.exam.demo.Entity;

// to give response to user
public class JwtResponse {

	String token;

	public JwtResponse() {}
	
	public JwtResponse(String token) {
		super();
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
