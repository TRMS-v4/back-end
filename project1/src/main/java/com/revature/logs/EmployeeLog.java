package com.revature.logs;

import java.util.List;

import com.revature.beans.Person;
import com.revature.daos.PersonDaoImp;
import com.revature.util.ServerLogger;

public class EmployeeLog {
	public static void empCreateLog() {
		PersonDaoImp pDao = new PersonDaoImp();
		Person p = pDao.getLast();
		ServerLogger.logger.info("Employee created. "
				+ "Employee id: "
				+ p.getP_id()
				+ ", First name: "
				+ p.getFirstname()
				+ ", Last name: "
				+ p.getLastname()
				+ ", position: "
				+ p.getPos_id());
	}
	
	public static void empGetByIdLog(Person p) {
		ServerLogger.logger.info("Get Employee. "
				+ "Employee id: "
				+ p.getP_id()
				+ ", First name: "
				+ p.getFirstname()
				+ ", Last name: "
				+ p.getLastname()
				+ ", position: "
				+ p.getPos_id());
	}
	
	public static void empGetAllLog(List<Person> pList) {
		ServerLogger.logger.info("Get All employees. count: "
				+ pList.size());
	}
	
	public static void empUpdateLog(Person p) {
		ServerLogger.logger.info("update Employee. "
				+ "Employee id: "
				+ p.getP_id()
				+ ", First name: "
				+ p.getFirstname()
				+ ", Last name: "
				+ p.getLastname()
				+ ", position: "
				+ p.getPos_id());
	}
	
	public static void empDeleteLog(Integer id) {
		ServerLogger.logger.info("Deleted Employee. id: "
				+ id
				);
	}
}
