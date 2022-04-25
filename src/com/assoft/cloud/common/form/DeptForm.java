package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.domain.db.po.Channel;

public class DeptForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AschemaDept dept;
	
	private boolean admin;
	
	private Channel rootChannel;
	
	private int userNum;//人员数量
	
	private int sonNum;//子机构数量
	
	private int serviceNum;//该部门能访问的服务数量

	public int getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}

	public AschemaDept getDept() {
		return dept;
	}

	public void setDept(AschemaDept dept) {
		this.dept = dept;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getSonNum() {
		return sonNum;
	}

	public void setSonNum(int sonNum) {
		this.sonNum = sonNum;
	}

	public Channel getRootChannel() {
		return rootChannel;
	}

	public void setRootChannel(Channel rootChannel) {
		this.rootChannel = rootChannel;
	}

	
	
	

}
