package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Position;
import com.revature.logs.PositionLog;
import com.revature.util.JDBC;

public class PositionDaoImp implements PositionDao {
	private Connection conn = JDBC.getConnection();

	@Override
	public boolean createPosition(Position pos) {
		String sql = "insert into trms.person_position values " + "(default,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pos.getPos());
			ps.execute();
			PositionLog.posCreateLog();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Position getById(Integer pos_id) {
		String sql = "select * from trms.person_position where pos_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pos_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Position pos = new Position();
				pos.setPos_id(rs.getInt("pos_id"));
				pos.setPos(rs.getString("pos"));
				PositionLog.posGetByIdLog(pos_id);
				return pos;
			}
		} catch (SQLException e) {

		}
		return null;
	}

	@Override
	public List<Position> getAll() {
		String sql = "select * from trms.person_position;";
		List<Position> posList = new ArrayList<Position>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Position pos = new Position();
				pos.setPos_id(rs.getInt("pos_id"));
				pos.setPos(rs.getString("pos"));
				posList.add(pos);
			}
			PositionLog.posGetAllLog(posList);
			return posList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Position p) {
		String sql = " update trms.person_position set "
				+ "pos= ? "
				+ "where pos_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getPos());
			ps.setInt(2, p.getPos_id());
			
			ps.execute();
			PositionLog.posUpdateLog(p);
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer pos_id) {
		String sql = "delete from trms.person_position where pos_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pos_id);
			ps.execute();
			PositionLog.posDeleteLog(pos_id);
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static void main(String[] args) {
		// test create
//		Position pos = new Position();
//		pos.setPos("pokemaster");
//		PositionDaoImp posDao = new PositionDaoImp();
//		posDao.createPosition(pos);

		// test getById
//		PositionDaoImp posDao = new PositionDaoImp();
//		System.out.println(posDao.getById(1));
		
		//test getAll
//		PositionDaoImp posDao = new PositionDaoImp();
//		System.out.println(posDao.getAll());
		
		//test update
//		Position pos = new Position();
//		pos.setPos_id(5);
//		pos.setPos("pokestupid");
//		PositionDaoImp posDao = new PositionDaoImp();
//		posDao.update(pos);
		
		//test delete
//		PositionDaoImp posDao = new PositionDaoImp();
//		posDao.deleteById(6);
	}
}
