package com.revature.logs;

import java.util.List;

import com.revature.beans.CourseEvent;
import com.revature.util.ServerLogger;

public class CELog {
	public static void CECreateLog() {
		ServerLogger.logger.info("Course Event created.");
	}
	
	public static void CEGetByIdLog(Integer id) {
		ServerLogger.logger.info("Getting Course Envet. id: "
				+ id);
	}
	
	public static void CEGetAllLog(List<CourseEvent> ceList) {
		ServerLogger.logger.info("Getting all Course Envet. count: "
				+ ceList.size());
	}
	
	public static void CEUpdageLog(Integer id) {
		ServerLogger.logger.info("Course Envet update. id: "
				+ id);
	}
	
	public static void CEDeleteLog(Integer id) {
		ServerLogger.logger.info("Course Envet deleted. id: "
				+ id);
	}
}
