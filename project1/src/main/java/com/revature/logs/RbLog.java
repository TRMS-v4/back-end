package com.revature.logs;

import java.util.List;

import com.revature.beans.Reimb;
import com.revature.util.ServerLogger;

public class RbLog {
	public static void RbCreateLog() {
		ServerLogger.logger.info("new Reimb Created");
	}
	
	public static void RbGetByIdLog(Integer id) {
		ServerLogger.logger.info("Getting Reimb by id: "
				+ id);
	}
	
	public static void RbGetByPIdLog(List<Reimb> rbList) {
		ServerLogger.logger.info("Getting by p_id. count: "
				+ rbList.size());
	}
	
	public static void RbGetByManagerLog(List<Reimb> rbList) {
		ServerLogger.logger.info("Getting by manager approval. count: "
				+ rbList.size());
	}
	
	public static void RbGetByDeptLog(List<Reimb> rbList) {
		ServerLogger.logger.info("Getting by department head approval. count: "
				+ rbList.size());
	}
	
	public static void RbGetByBenCoLog(List<Reimb> rbList) {
		ServerLogger.logger.info("Getting by BenCo approval. count: "
				+ rbList.size());
	}
	
	public static void RbGetAllLog(List<Reimb> rbList) {
		ServerLogger.logger.info("Getting all Reimbs. count: "
				+ rbList.size());
	}
	public static void RbUpdateLog(Integer id) {
		ServerLogger.logger.info("Update Reimbs. id: "
				+ id);
	}
	public static void RbDeleteLog(Integer id) {
		ServerLogger.logger.info("Reimbs deleted. id: "
				+ id);
	}
}
