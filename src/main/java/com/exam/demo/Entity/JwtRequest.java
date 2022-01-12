package com.exam.demo.Entity;

// I will get these from user
public class JwtRequest {

	String username ;
	String password;
	
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public JwtRequest() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
