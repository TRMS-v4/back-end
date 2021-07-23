package com.revature.service;

import java.util.List;

import com.revature.beans.Reimb;
import com.revature.daos.ReimbDaoImp;

public class DeptHeadService {
public static ReimbDaoImp rbDao = new ReimbDaoImp();
	
	public static List<Reimb> getByDeptHeadAprr() {
		
		return rbDao.getByDeptHeadAppr();
	}
	
	public static Reimb deptHeadAppr(Reimb rb) {
		
		rb.setDeptHeadAppr(true);
		
		Reimb newRb = rbDao.update(rb);
		
		return rb;
	}
}
