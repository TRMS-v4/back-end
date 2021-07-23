package com.revature.beans;

import java.sql.Date;
import java.sql.Time;

public class CourseEvent {
	private Integer Course_id;
	private Double cost;
	private Date start_date;
	private Date end_date;
	private Time course_time_start;
	private Time course_time_end;
	private String subject;
	private Integer grade_format_id;
	private boolean passing_grade;
	private String loc;
	private String des;
	public Integer getCourse_id() {
		return Course_id;
	}
	public void setCourse_id(Integer course_id) {
		Course_id = course_id;
	}
	
	
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Time getCourse_time_start() {
		return course_time_start;
	}
	public void setCourse_time_start(Time course_time_start) {
		this.course_time_start = course_time_start;
	}
	public Time getCourse_time_end() {
		return course_time_end;
	}
	public void setCourse_time_end(Time course_time_end) {
		this.course_time_end = course_time_end;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getGrade_format_id() {
		return grade_format_id;
	}
	public void setGrade_format_id(Integer grade_format_id) {
		this.grade_format_id = grade_format_id;
	}
	public boolean isPassing_grade() {
		return passing_grade;
	}
	public void setPassing_grade(boolean passing_grade) {
		this.passing_grade = passing_grade;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	@Override
	public String toString() {
		return "CourseEvent [Course_id=" + Course_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", course_time_start=" + course_time_start + ", course_time_end=" + course_time_end + ", subject="
				+ subject + ", grade_format_id=" + grade_format_id + ", passing_grade=" + passing_grade + ", loc=" + loc
				+ ", des=" + des + "]";
	}
	
	
}
