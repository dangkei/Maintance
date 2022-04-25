package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

/**
 * 组织机构信息
 * 包含子部门和用户列表
 * @author wzj
 *
 */
public class OrgForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private DeptForm curDept;//当前部门
	
	private List<DeptForm> sonDepts;//子部门列表
	
	private List<UserForm> users;//用户列表


	

	

	public DeptForm getCurDept() {
		return curDept;
	}

	public void setCurDept(DeptForm curDept) {
		this.curDept = curDept;
	}

	public List<DeptForm> getSonDepts() {
		return sonDepts;
	}

	public void setSonDepts(List<DeptForm> sonDepts) {
		this.sonDepts = sonDepts;
	}

	public List<UserForm> getUsers() {
		return users;
	}

	public void setUsers(List<UserForm> users) {
		this.users = users;
	}

	
	
	
}
