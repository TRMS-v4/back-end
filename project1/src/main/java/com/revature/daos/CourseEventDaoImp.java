package com.revature.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CourseEvent;
import com.revature.logs.CELog;
import com.revature.util.JDBC;

public class CourseEventDaoImp implements CourseEventDao {
	
	private Connection conn = JDBC.getConnection();
	
	@Override
	public CourseEvent createCourseEvent(CourseEvent ce) {
		String sql = "insert into trms.course_event values (default,?,?,?,?,?,?,?,?) returning course_id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, ce.getStart_date());
			ps.setDate(2, ce.getEnd_date());
			ps.setString(3, ce.getSubject());
			ps.setInt(4, ce.getGrade_format_id());
			ps.setString(5, ce.getLoc());
			ps.setString(6, ce.getDes());
			ps.setBoolean(7, ce.isPassing_grade());
			ps.setDouble(8, ce.getCost());
//			ps.execute();
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
//				System.out.println("key: " + rs.getInt(1));
				ce.setCourse_id(Integer.valueOf(rs.getInt(1)));
				CELog.CECreateLog();
			}else {
				System.out.println("something wrong...");
			}
			return ce;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public CourseEvent getById(Integer course_id) {
		String sql = "select * from trms.course_event where course_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, course_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				CourseEvent ce = new CourseEvent();
				ce.setCourse_id(course_id);
				ce.setStart_date(rs.getDate("start_date"));
				ce.setEnd_date(rs.getDate("end_date"));
				ce.setSubject(rs.getString("subject"));
				ce.setGrade_format_id(rs.getInt("grade_format_id"));
				ce.setLoc(rs.getString("loc"));
				ce.setDes(rs.getString("des"));
				ce.setPassing_grade(rs.getBoolean("passing_grade"));
				ce.setCost(rs.getDouble("cost"));
				CELog.CEGetByIdLog(course_id);
				return ce;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<CourseEvent> getAll() {
		String sql = "select * from trms.course_event;";
		List<CourseEvent> ceList = new ArrayList<CourseEvent>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CourseEvent ce = new CourseEvent();
				ce.setCourse_id(rs.getInt("course_id"));
				ce.setStart_date(rs.getDate("start_date"));
				ce.setEnd_date(rs.getDate("end_date"));
				ce.setSubject(rs.getString("subject"));
				ce.setGrade_format_id(rs.getInt("grade_format_id"));
				ce.setLoc(rs.getString("loc"));
				ce.setDes(rs.getString("des"));
				ce.setPassing_grade(rs.getBoolean("passing_grade"));
				ce.setCost(rs.getDouble("cost"));
				ceList.add(ce);
				
			}
			
			CELog.CEGetAllLog(ceList);
			return ceList;

		}catch(SQLException e) {
			
		}
		
		
		return null;
	}

	@Override
	public boolean update(CourseEvent ce) {
		String sql = "update trms.course_event set start_date =?, end_date=?, subject=?, grade_format_id=?, loc=?, des=?, passing_grade=?, cost= ? where course_id=?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, ce.getStart_date());
			ps.setDate(2, ce.getEnd_date());
			ps.setString(3, ce.getSubject());
			ps.setInt(4, ce.getGrade_format_id());
			ps.setString(5, ce.getLoc());
			ps.setString(6, ce.getDes());
			ps.setBoolean(7, ce.isPassing_grade());
			ps.setDouble(8, ce.getCost());
			ps.setInt(9, ce.getCourse_id());
			
			ps.execute();
			CELog.CEUpdageLog(ce.getCourse_id());
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer course_id) {
		String sql = "delete from trms.course_event where course_id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, course_id);
			ps.execute();
			CELog.CEDeleteLog(course_id);
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	public static void main(String[] args) {
//		//creation test
//		CourseEvent ce = new CourseEvent();
//		Date start = new Date(120,1,1);
//		System.out.println(start);
//		Date end = new Date(120,2,1);
//		ce.setStart_date(start);
//		ce.setEnd_date(end);
//		ce.setGrade_format_id(1);
//		ce.setSubject("test1");
//		ce.setDes("testing subject course");
//		ce.setLoc("testing here");
//		ce.setCost(100d);
//		ce.setPassing_grade(false);
//		
//		CourseEventDaoImp ceDao = new CourseEventDaoImp();
//		
//		CourseEvent newce = ceDao.createCourseEvent(ce);
//		System.out.println(newce);
//		
//		if(ceDao.createCourseEvent(ce)) {
//			System.out.println("creation successful");
//		}else {
//			System.out.println("creation unsuccessful");
//		}
		
		//get test
//		CourseEventDaoImp ceDao = new CourseEventDaoImp();
//		CourseEvent ce = ceDao.getById(3);
//		System.out.println(ce);
		
//		CourseEventDaoImp ceDao = new CourseEventDaoImp();
//		System.out.println(ceDao.getAll());
		
		//update test
//		CourseEvent ce = new CourseEvent();
//		Date start = new Date(120,1,1);
//		System.out.println(start);
//		Date end = new Date(120,9,1);
//		ce.setCourse_id(3);
//		ce.setStart_date(start);
//		ce.setEnd_date(end);
//		ce.setGrade_format_id(1);
//		ce.setSubject("test 2");
//		ce.setDes("testing subject course");
//		ce.setLoc("testing there");
//		ce.setPassing_grade(true);
//		CourseEventDaoImp ceDao = new CourseEventDaoImp();
//		ceDao.update(ce);
		
		//delete test
		
//		CourseEventDaoImp ceDao = new CourseEventDaoImp();
//		ceDao.deleteById(5);
//	}
}
