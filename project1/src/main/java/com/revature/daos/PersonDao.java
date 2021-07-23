package com.revature.daos;

import java.util.List;

import com.revature.beans.Person;

public interface PersonDao {
	//create
	public boolean createPerson(Person p);
	
	//get
	public Person getById(Integer p_id);
	
	public List<Person> getAll();
	
	//update
	public boolean update(Person p);
	
	//delete
	public boolean deleteById(Integer p_id);
	
}
