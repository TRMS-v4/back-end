package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Email;
import com.revature.util.JDBC;

public class EmailDaoImp implements EmailDao {

	private Connection conn = JDBC.getConnection();

	@Override
	public boolean createEmail(Email em) {
		String sql = "insert into trms.email values" + "(default, ?, ?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em.getEmail());
			ps.setInt(2, em.getP_id());

			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Email getEmailById(Integer email_id) {
		String sql = "select * from trms.email where email_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, email_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Email em = new Email();
				em.setEmail_id(rs.getInt("email_id"));
				em.setP_id(rs.getInt("p_id"));
				em.setEmail(rs.getString("email"));

				return em;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Email getEmailByPId(Integer p_id) {
		String sql = "select * from trms.email where p_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Email em = new Email();
				em.setEmail_id(rs.getInt("email_id"));
				em.setP_id(rs.getInt("p_id"));
				em.setEmail(rs.getString("email"));

				return em;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Email> getAll() {
		String sql = "select * from trms.email;";
		List<Email> emList = new ArrayList<Email>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Email em = new Email();
				em.setEmail_id(rs.getInt("email_id"));
				em.setP_id(rs.getInt("p_id"));
				em.setEmail(rs.getString("email"));
				emList.add(em);

			}
			return emList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Email em) {
		String sql = "update trms.email set email=?, p_id=? where email_id=?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em.getEmail());
			ps.setInt(2, em.getP_id());
			ps.setInt(3, em.getEmail_id());
			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteById(Integer email_id) {
		String sql = "delete from trms.email where email_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, email_id);
			ps.execute();
			return true;
		} catch (SQLException e) {

		}
		return false;
	}

	@Override
	public boolean deleteByPID(Integer p_id) {
		String sql = "delete from trms.email where p_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p_id);
			ps.execute();
			return true;
		} catch (SQLException e) {

		}
		return false;
	}

	public static void main(String[] args) {
		// test create
//		EmailDaoImp emDao = new EmailDaoImp();
//		Email em = new Email();
//		em.setEmail("johndoe@gmail.com");
//		em.setP_id(3);
//		emDao.createEmail(em);

		// test getById
//		EmailDaoImp emDao = new EmailDaoImp();
//		System.out.println(emDao.getEmailById(1));

		// test getByPid
//		EmailDaoImp emDao = new EmailDaoImp();
//		System.out.println(emDao.getEmailByPId(1));

		// test getAll
//		EmailDaoImp emDao = new EmailDaoImp();
//		System.out.println(emDao.getAll());

		// test update
//		EmailDaoImp emDao = new EmailDaoImp();
//		Email em = new Email();
//		em.setEmail_id(1);
//		em.setEmail("john@gmail.com");
//		em.setP_id(3);
//		emDao.update(em);

		// deletebyid
//		EmailDaoImp emDao = new EmailDaoImp();
//		emDao.deleteById(1);

	}
}
