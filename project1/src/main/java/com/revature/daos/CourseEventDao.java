package com.revature.daos;

import java.util.List;

import com.revature.beans.CourseEvent;

public interface CourseEventDao {
	
	//create
	public CourseEvent createCourseEvent(CourseEvent ce);
	
	//get
	public CourseEvent getById(Integer course_id);
	
	public List<CourseEvent> getAll();
	
	//update
	public boolean update(CourseEvent ce);
	
	//delete
	public boolean deleteById(Integer course_id);
	
}
