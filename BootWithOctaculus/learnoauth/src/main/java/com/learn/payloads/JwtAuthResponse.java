package com.learn.payloads;

public class JwtAuthResponse {

	private String token;
	

	public JwtAuthResponse() {
		super();
	}

	public JwtAuthResponse(String token) {
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
