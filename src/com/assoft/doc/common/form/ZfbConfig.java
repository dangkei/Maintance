package com.assoft.doc.common.form;

import java.io.Serializable;
import java.util.List;

public class ZfbConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1282842047353807737L;
	private String llyId ;
	private String llyName;
	private String deptId;
	private String deptName;
	public String getLlyId() {
		return llyId;
	}
	public void setLlyId(String llyId) {
		this.llyId = llyId;
	}
	public String getLlyName() {
		return llyName;
	}
	public void setLlyName(String llyName) {
		this.llyName = llyName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
