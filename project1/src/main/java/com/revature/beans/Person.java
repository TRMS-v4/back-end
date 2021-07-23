package com.revature.beans;

public class Person {
	private Integer p_id;
	private String firstname;
	private String lastname;
	private String username;
	private String pass;
	private Integer pos_id;
	private Double reimb_limit;
	
	
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getPos_id() {
		return pos_id;
	}
	public void setPos_id(Integer pos_id) {
		this.pos_id = pos_id;
	}
	
	public Double getReimb_limit() {
		return reimb_limit;
	}
	public void setReimb_limit(Double reimb_limit) {
		this.reimb_limit = reimb_limit;
	}
	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", firstname=" + firstname + ", lastname=" + lastname + ", pass=" + pass
				+ ", pos_id=" + pos_id + "]";
	}
	
}
