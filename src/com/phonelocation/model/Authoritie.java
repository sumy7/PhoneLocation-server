package com.phonelocation.model;

public class Authoritie {
	public final static String ROLE_ADMIN = "ROLE_ADMIN";
	public final static String ROLE_USER = "ROLE_USER";

	private String username;
	private String authority;

	public Authoritie() {
	}

	public Authoritie(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
