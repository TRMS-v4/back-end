package com.revature.service;

import com.revature.beans.LoginBean;
import com.revature.beans.Person;
import com.revature.daos.PersonDaoImp;

public class LoginService {
	private static PersonDaoImp pDao = new PersonDaoImp();
	
	public static Person usernameCheck(String username) {
		Person p = pDao.getByUsername(username);
		if( p != null) {
			return p;
		}
		
		return null;
	}
	
	public static boolean passCheck(Person p, String pass) {
		
		if(p.getPass().equals(pass)) {
			return true;
		}
		
		return false;
	}
	
	public static Person accountLogin(LoginBean lb) {
		
		String username = lb.getUsername();
		String pass = lb.getPassword();
		System.out.println("check pass: " + pass);
		System.out.println("username check: "+ username);
		Person p = usernameCheck(username);
		if(p != null) {
			if(passCheck(p, pass)) {
				System.out.println("login successful.");
				return p;
			}else {
				System.out.println("password mismatch.");
				return null;
			}
		}else {
			System.out.println("user not found.");
			return null;
		}
	}
	
	public boolean registerAccount(Person p) {
		if(pDao.createPerson(p)) {
			return true;
		};
		
		return false;
	}
	
	
//	public static void main(String[] args) {
//		//test account login
//		String username = "pokemodn";
//		String pass = "passd";
//		accountLogin(username, pass);
//	}
}
