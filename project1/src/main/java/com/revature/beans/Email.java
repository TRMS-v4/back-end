package com.revature.beans;

public class Email {
	private Integer email_id;
	private String email;
	private Integer p_id;
	
	
	public Integer getEmail_id() {
		return email_id;
	}
	public void setEmail_id(Integer email_id) {
		this.email_id = email_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	
	@Override
	public String toString() {
		return "Email [email_id=" + email_id + ", email=" + email + ", p_id=" + p_id + "]";
	}
	
}
