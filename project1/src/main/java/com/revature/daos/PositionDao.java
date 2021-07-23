package com.revature.daos;

import java.util.List;

import com.revature.beans.Position;

public interface PositionDao {
	//create
	public boolean createPosition(Position pos);
	
	//get
	public Position getById(Integer pos_id);
	
	public List<Position > getAll();
	
	//update
	public boolean update(Position p);
	
	//delete
	public boolean deleteById(Integer pos_id);
	
}
