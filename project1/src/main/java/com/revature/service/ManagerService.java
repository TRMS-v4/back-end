package com.revature.service;

import java.util.List;

import com.revature.beans.Reimb;
import com.revature.daos.ReimbDaoImp;

public class ManagerService {
	public static ReimbDaoImp rbDao = new ReimbDaoImp();
	
	public static List<Reimb> getByManagerAprr() {
		
		return rbDao.getByManagerAppr();
	}
	
	public static Reimb managerAppr(Reimb rb) {
		rb.setsAppr(true);
		rbDao.update(rb);
		return rb;
	}
}
