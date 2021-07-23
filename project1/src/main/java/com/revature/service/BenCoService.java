package com.revature.service;

import java.util.List;

import com.revature.beans.Person;
import com.revature.beans.Reimb;
import com.revature.daos.PersonDaoImp;
import com.revature.daos.ReimbDaoImp;

public class BenCoService {
	public static ReimbDaoImp rbDao = new ReimbDaoImp();
	public static PersonDaoImp pDao = new PersonDaoImp();

	public static List<Reimb> getByBencoAprr() {

		return rbDao.getByBencoAppr();
	}

	public static Reimb benCoAppr(Reimb rb) {
		System.out.println("rb" + rb);
		Person p = pDao.getById(rb.getP_id());
		System.out.println("limit before: " + p.getReimb_limit());
		if(p.getReimb_limit() > rb.getReimb_amount()) {
			p.setReimb_limit(p.getReimb_limit()-rb.getReimb_amount());
			System.out.println("limit after: " + p.getReimb_limit());
			if(pDao.update(p)) {
				System.out.println("person update successful");
			}else {
				System.out.println("person update unsuccessful");
			}
			rb.setBencoAppr(true);
			System.out.println("ab after " + rb);
			Reimb newRb = rbDao.update(rb);
			return newRb;
		}
		if(p.getReimb_limit() < rb.getReimb_amount()) {
			System.out.println("Not enough limit");
		}
		
		return null;
	}
}
