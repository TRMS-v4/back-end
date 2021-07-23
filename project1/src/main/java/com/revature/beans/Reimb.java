package com.revature.beans;

public class Reimb {
	private Integer reimb_id;
	private Double reimb_amount;
	private boolean sAppr;
	private boolean deptHeadAppr;
	private boolean bencoAppr;
	private Integer p_id;
	private Integer course_id;
	private boolean grade_pass;
	
	public Reimb() {
		this.sAppr= false;
		this.deptHeadAppr= false;
		this.bencoAppr = false;
		this.grade_pass = false;
	}
	
	public Integer getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(Integer reimb_id) {
		this.reimb_id = reimb_id;
	}
	
	public Double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(Double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public boolean issAppr() {
		return sAppr;
	}
	public void setsAppr(boolean sAppr) {
		this.sAppr = sAppr;
	}
	public boolean isDeptHeadAppr() {
		return deptHeadAppr;
	}
	public void setDeptHeadAppr(boolean deptHeadAppr) {
		this.deptHeadAppr = deptHeadAppr;
	}
	public boolean isBencoAppr() {
		return bencoAppr;
	}
	public void setBencoAppr(boolean bencoAppr) {
		this.bencoAppr = bencoAppr;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public boolean isGrade_pass() {
		return grade_pass;
	}
	public void setGrade_pass(boolean grade_pass) {
		this.grade_pass = grade_pass;
	}
	@Override
	public String toString() {
		return "Reimb [reimb_id=" + reimb_id + ", cost=" + reimb_amount + ", sAppr=" + sAppr + ", deptHeadAppr=" + deptHeadAppr
				+ ", bencoAppr=" + bencoAppr + ", p_id=" + p_id + ", course_id=" + course_id + ", grade_pass="
				+ grade_pass + "]";
	}
	
}
