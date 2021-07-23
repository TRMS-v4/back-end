package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Person;
import com.revature.logs.EmployeeLog;
import com.revature.util.JDBC;

public class PersonDaoImp implements PersonDao {

	private Connection conn = JDBC.getConnection();

	@Override
	public boolean createPerson(Person p) {
		String sql = "insert into trms.person values" + "(default, ?,?,?,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getFirstname());
			ps.setString(2, p.getLastname());
			ps.setString(3, p.getUsername());
			ps.setString(4, p.getPass());
			ps.setInt(5, p.getPos_id());
			ps.setDouble(6, p.getReimb_limit());

			ps.execute();
			EmployeeLog.empCreateLog();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Person getById(Integer p_id) {
		String sql = "select * from trms.person where p_id =?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Person p = new Person();
				p.setP_id(rs.getInt("p_id"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setUsername(rs.getString("username"));
				p.setPass(rs.getString("pass"));
				p.setPos_id(rs.getInt("pos_id"));
				p.setReimb_limit(rs.getDouble("reimb_limit"));
				EmployeeLog.empGetByIdLog(p);
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Person getByUsername(String username) {
		String sql = "select * from trms.person where username = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Person p = new Person();
				p.setP_id(rs.getInt("p_id"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setUsername(rs.getString("username"));
				p.setPass(rs.getString("pass"));
				p.setPos_id(rs.getInt("pos_id"));
				p.setReimb_limit(rs.getDouble("reimb_limit"));
				
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Person> getAll() {
		String sql = "select * from trms.person;";
		List<Person> people = new ArrayList<Person>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Person p = new Person();
				p.setP_id(rs.getInt("p_id"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setUsername(rs.getString("username"));
				p.setPass(rs.getString("pass"));
				p.setPos_id(rs.getInt("pos_id"));
				p.setReimb_limit(rs.getDouble("reimb_limit"));
				
				people.add(p);
			}
			EmployeeLog.empGetAllLog(people);
			return people;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Person getLast() {
		String sql = "select * from trms.person where p_id = (select max(p_id) from trms.person);";
		
		Person p = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Person();
				p.setP_id(rs.getInt("p_id"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setUsername(rs.getString("username"));
				p.setPass(rs.getString("pass"));
				p.setPos_id(rs.getInt("pos_id"));
				p.setReimb_limit(rs.getDouble("reimb_limit"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}

	@Override
	public boolean update(Person p) {
		String sql = "update trms.person set "
				+ "firstname =?, "
				+ "lastname = ?, "
				+ "username = ?, "
				+ "pass = ?, "
				+ "pos_id = ?, "
				+ "reimb_limit = ?"
				+ "where p_id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getFirstname());
			ps.setString(2, p.getLastname());
			ps.setString(3, p.getUsername());
			ps.setString(4, p.getPass());
			ps.setInt(5, p.getPos_id());
			ps.setDouble(6, p.getReimb_limit());
			ps.setInt(7, p.getP_id());
			
			ps.execute();
			EmployeeLog.empUpdateLog(p);
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer p_id) {
		String sql = "delete from trms.person where p_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p_id);
			EmployeeLog.empDeleteLog(p_id);
			ps.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		// test create
//		Person p = new Person();
//		p.setFirstname("f");
//		p.setLastname("l");
//		p.setUsername("test");
//		p.setPass("pass");
//		p.setPos_id(1);
//		p.setReimb_limit(1000d);
//		PersonDaoImp pDao = new PersonDaoImp();
//		pDao.createPerson(p);

		// test getById
//		PersonDaoImp pDao = new PersonDaoImp();
//		System.out.println(pDao.getById(4));
		
		//test getByname
//		PersonDaoImp pDao = new PersonDaoImp();
//		System.out.println(pDao.getByUsername("pokemon"));
		
		//test getAll
//		PersonDaoImp pDao = new PersonDaoImp();
//		System.out.println(pDao.getAll());
//		
		//test getLast()
//		PersonDaoImp pDao = new PersonDaoImp();
//		System.out.println(pDao.getLast());
		
		
		
		//test update
//		Person p = new Person();
//		p.setP_id(4);
//		p.setFirstname("poke");
//		p.setLastname("mon");
//		p.setUsername("pokemon");
//		p.setPass("pass");
//		p.setPos_id(1);
//		PersonDaoImp pDao = new PersonDaoImp();
//		pDao.update(p);
		
		//test delete
//		PersonDaoImp pDao = new PersonDaoImp();
//		pDao.deleteById(3);
	}

}
