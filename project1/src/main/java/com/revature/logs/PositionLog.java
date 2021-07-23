package com.revature.logs;

import java.util.List;

import com.revature.beans.Position;
import com.revature.util.ServerLogger;

public class PositionLog {
	public static void posCreateLog() {
		ServerLogger.logger.info("new position created");
	}
	
	public static void posGetByIdLog(Integer id) {
		ServerLogger.logger.info("Getting position with id: "
				+ id);
	}
	
	public static void posGetAllLog(List<Position> posList) {
		ServerLogger.logger.info("Get all positions. count:  "
				+ posList.size());
	}
	
	public static void posUpdateLog(Position pos) {
		ServerLogger.logger.info("position updated. id: "
				+ pos.getPos_id());
	}
	
	public static void posDeleteLog(Integer id) {
		ServerLogger.logger.info("position delete. id: "
				+ id);
	}
}
