package com.revature.service;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

import com.revature.beans.CEBean;
import com.revature.beans.CourseEvent;
import com.revature.beans.Person;
import com.revature.beans.Reimb;
import com.revature.daos.CourseEventDaoImp;
import com.revature.daos.ReimbDaoImp;

public class EmployeeService {
	private static CourseEventDaoImp ceDao = new CourseEventDaoImp();
	private static ReimbDaoImp reimbDao = new ReimbDaoImp();
	public static boolean applyNew(Person p, CourseEvent ce) {
		Reimb rb = new Reimb();
//		rb.setCost(null);
		
		return false;
		
	}
	public static Double reAmount(Double cost, String inst) {
		if(cost < 0) {
			return null;
		}
		Double rb;
		switch(inst) {
		case "university": rb = cost*0.8;
			break;
		case "seminar": rb = cost*0.6;
		break;
		case "preparation": rb = cost*0.75;
		break;
		case "certification": rb = cost;
		break;
		case "tech-training": rb=cost*0.9;
		break;
		case "other": rb=cost*0.3;
		default: rb= 0d;
		break;
		}
		return rb;
	}
	
	public static Reimb createReimb(CEBean ceb, CourseEvent ce) {
		Reimb reimb = new Reimb();
		reimb.setReimb_amount(reAmount(ceb.getCost(), ceb.getInst()));
		reimb.setP_id(ceb.getP_id());
		reimb.setCourse_id(ce.getCourse_id());
		
		return reimbDao.createReimb(reimb);
	}
	
	public static CourseEvent createCE(CEBean ceb) {
		CourseEvent ce = new CourseEvent();
		
		Date start = Date.valueOf(ceb.getStart());
		Date end = Date.valueOf(ceb.getEnd());
		ce.setStart_date(start);
		ce.setEnd_date(end);
		ce.setSubject(ceb.getSubject());
		switch(ceb.getGrade_format()) {
		case "letter grade": ce.setGrade_format_id(1);
		break;
		case "pass fail": ce.setGrade_format_id(2);
		break;
		default: ce.setGrade_format_id(1);
		}
		ce.setLoc(ceb.getLoc());
		ce.setDes(ceb.getDes());
		ce.setCost(ceb.getCost());
		ce = ceDao.createCourseEvent(ce);
		
		
		return ce;
	}
	
	public static List<Reimb> pullRecords(Integer p_id){
		return reimbDao.getByPId(p_id);
	}
	
	
//	public static void main(String[] args) {
		//test reAmount
//		Double cost = 300d;
//		String inst = "tech-training";
//		
//		System.out.println(reAmount(cost, inst));
		//test createReimb
		
		
//	}
}
