package com.revature.beans;

public class Position {
	private Integer pos_id;
	private String pos;
	public Integer getPos_id() {
		return pos_id;
	}
	public void setPos_id(Integer pos_id) {
		this.pos_id = pos_id;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "Position [pos_id=" + pos_id + ", pos=" + pos + "]";
	}
	
}
