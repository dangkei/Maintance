package com.assoft.cloud.common.value;

import java.io.Serializable;

public abstract class DeskItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	protected int pos;
	
	protected String name;
	
	protected String type;

	protected String popType;

	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPopType() {
		return popType;
	}

	public void setPopType(String popType) {
		this.popType = popType;
	}

	
	
	

}
