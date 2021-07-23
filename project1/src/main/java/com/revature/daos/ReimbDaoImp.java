package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimb;
import com.revature.logs.RbLog;
import com.revature.util.JDBC;

public class ReimbDaoImp implements ReimbDao {

	private Connection conn = JDBC.getConnection();

	@Override
	public Reimb createReimb(Reimb reimb) {
		String sql = "insert into trms.reimb values " + "(default,?,?,?,?,?,?,?) returning  reimb_id;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimb.getReimb_amount());
			ps.setBoolean(2, reimb.issAppr());
			ps.setBoolean(3, reimb.isDeptHeadAppr());
			ps.setBoolean(4, reimb.isBencoAppr());
			ps.setInt(5, reimb.getP_id());
			ps.setInt(6, reimb.getCourse_id());
			ps.setBoolean(7, reimb.isGrade_pass());

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reimb.setReimb_id(Integer.valueOf(rs.getInt(1)));
				RbLog.RbCreateLog();
				return reimb;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimb getById(Integer reimb_id) {
		String sql = "select * from trms.reimb where reimb_id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));
				RbLog.RbGetByIdLog(reimb_id);
				return reimb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimb> getByPId(Integer p_id) {
		String sql = "select * from trms.reimb where p_id = ?;";
		List<Reimb> reimbList = new ArrayList<Reimb>();
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));

				reimbList.add(reimb);
			}
			RbLog.RbGetByPIdLog(reimbList);
			return reimbList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimb> getAll() {
		String sql = "select * from trms.reimb;";
		List<Reimb> reimbList = new ArrayList<Reimb>();
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));

				reimbList.add(reimb);
			}
			RbLog.RbGetAllLog(reimbList);
			return reimbList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public List<Reimb> getByManagerAppr(){
		String sql = "select * from trms.reimb where supervisor_appr = false;";
		List<Reimb> reimbList = new ArrayList<Reimb>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));

				reimbList.add(reimb);
			}
			
			RbLog.RbGetByManagerLog(reimbList);
			return reimbList;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Reimb> getByDeptHeadAppr(){
		String sql = "select * from trms.reimb where dept_head_appr = false and supervisor_appr = true;";
		List<Reimb> reimbList = new ArrayList<Reimb>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));

				reimbList.add(reimb);
			}
			RbLog.RbGetByDeptLog(reimbList);
			return reimbList;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Reimb> getByBencoAppr(){
		String sql = "select * from trms.reimb where benco_appr = false and dept_head_appr = true and supervisor_appr = true;";
		List<Reimb> reimbList = new ArrayList<Reimb>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));

				reimbList.add(reimb);
			}
			RbLog.RbGetByBenCoLog(reimbList);
			return reimbList;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimb> getByCourseId(Integer course_id) {
		String sql = "select * from trms.reimb where course_id = ?;";
		List<Reimb> reimbList = new ArrayList<Reimb>();
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, course_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimb reimb = new Reimb();
				reimb.setReimb_id(rs.getInt("reimb_id"));
				reimb.setReimb_amount(rs.getDouble("reimb_amount"));
				reimb.setsAppr(rs.getBoolean("supervisor_appr"));
				reimb.setDeptHeadAppr(rs.getBoolean("dept_head_appr"));
				reimb.setBencoAppr(rs.getBoolean("benco_appr"));
				reimb.setP_id(rs.getInt("p_id"));
				reimb.setCourse_id(rs.getInt("course_id"));
				reimb.setGrade_pass(rs.getBoolean("grade_pass"));

				reimbList.add(reimb);
			}
			return reimbList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimb update(Reimb reimb) {
		String sql = "update trms.reimb set "
				+ "reimb_amount = ?, "
				+ "supervisor_appr = ?,"
				+ "dept_head_appr = ?, "
				+ "benco_appr = ?, "
//				+ "p_id = ?, "
//				+ "course_id = ?, "
				+ "grade_pass = ? "
				+ "where reimb_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimb.getReimb_amount());
			ps.setBoolean(2, reimb.issAppr());
			ps.setBoolean(3, reimb.isDeptHeadAppr());
			ps.setBoolean(4, reimb.isBencoAppr());
//			ps.setInt(5, reimb.getP_id());
//			ps.setInt(6, reimb.getCourse_id());
			ps.setBoolean(5, reimb.isGrade_pass());
			ps.setInt(6, reimb.getReimb_id());

			ps.execute();
			RbLog.RbUpdateLog(reimb.getReimb_id());
			return reimb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean delete(Integer reimb_id) {
		String sql = " delete from trms.reimb where reimb_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimb_id);
			ps.execute();
			RbLog.RbDeleteLog(reimb_id);
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

//	public static void main(String[] args) {
		// test create
//		Reimb reimb = new Reimb();
//		reimb.setReimb_amount(100d);
//		reimb.setsAppr(false);
//		reimb.setDeptHeadAppr(false);
//		reimb.setBencoAppr(false);
//		reimb.setP_id(4);
//		reimb.setCourse_id(7);
//		reimb.setGrade_pass(false);
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		reimbDao.createReimb(reimb);

		// test getById
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		System.out.println(reimbDao.getById(1));

		// test getByPid
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		System.out.println(reimbDao.getByPId(4));

		// test getAll
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		System.out.println(reimbDao.getAll());

		// test getByCourseId
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		System.out.println(reimbDao.getByCourseId(6));
		
		//test update
//		Reimb reimb = new Reimb();
//		reimb.setReimb_id(1);;
//		reimb.setCost(100d);
//		reimb.setsAppr(true);
//		reimb.setDeptHeadAppr(true);
//		reimb.setBencoAppr(true);
//		reimb.setP_id(4);
//		reimb.setCourse_id(6);
//		reimb.setGrade_pass(false);
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		reimbDao.update(reimb);
		
		//test delete
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		reimbDao.delete(2);
		
		//test getbymanagerappr
//		ReimbDaoImp reimbDao = new ReimbDaoImp();
//		System.out.println(reimbDao.getByBencoAppr());
//	}

}
