package com.phonelocation.model;

public class Token {

	private String owner;
	private String tokenid;
	private Long deadline;

	public Token() {

	}

	public Token(String owner, String tokenid, Long deadline) {
		this.owner = owner;
		this.tokenid = tokenid;
		this.deadline = deadline;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTokenid() {
		return tokenid;
	}

	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	public Long getDeadline() {
		return deadline;
	}

	public void setDeadline(Long deadline) {
		this.deadline = deadline;
	}

}
