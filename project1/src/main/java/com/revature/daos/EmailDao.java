package com.revature.daos;

import java.util.List;

import com.revature.beans.Email;

public interface EmailDao {
	//create
	public boolean createEmail(Email e);
	
	//get
	public Email getEmailById(Integer email_id);
	
	public Email getEmailByPId(Integer p_id);
	
	public List<Email> getAll();
	
	//update
	public boolean update(Email e);
	
	//delete
	public boolean deleteById(Integer email_id);
	
	public boolean deleteByPID(Integer p_id);
}
