package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimb;

public interface ReimbDao {
	//create
	public Reimb createReimb(Reimb reimb);
	
	//get
	public Reimb getById(Integer reimb_id);
	
	public List<Reimb> getByPId(Integer p_id);
	
	public List<Reimb> getAll();
	
	public List<Reimb> getByCourseId(Integer course_id);
	
	public Reimb update(Reimb reimb);
	
	public boolean delete(Integer reimb_id);

}
