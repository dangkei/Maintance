package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaUser;

public class DeptUserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaUser user;
	
	private String curDeptId;//当前部门标识
	
	private List<AschemaDept> relativeDepts;//相对路径

	public AschemaUser getUser() {
		return user;
	}

	public String getCurDeptId() {
		return curDeptId;
	}

	public List<AschemaDept> getRelativeDepts() {
		return relativeDepts;
	}

	public void setUser(AschemaUser user) {
		this.user = user;
	}

	public void setCurDeptId(String curDeptId) {
		this.curDeptId = curDeptId;
	}

	public void setRelativeDepts(List<AschemaDept> relativeDepts) {
		this.relativeDepts = relativeDepts;
	}
	
	
	
	
	

}
