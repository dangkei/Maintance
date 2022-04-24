package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaAuthScope;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.cloudclient.common.AsopSectionInfo;

public class UserForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaUser user;
	
	private AschemaDept dept;
	

	private AsopSectionInfo sectionInfo;
	
	

	
	private int serviceNum;//该用户能访问的服务数量
	
	private List<AschemaAuthScope> authList;
	
	
	public AschemaUser getUser() {
		return user;
	}

	public void setUser(AschemaUser user) {
		this.user = user;
	}

	public AschemaDept getDept() {
		return dept;
	}

	public void setDept(AschemaDept dept) {
		this.dept = dept;
	}

	public int getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}

	public List<AschemaAuthScope> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AschemaAuthScope> authList) {
		this.authList = authList;
	}

	public AsopSectionInfo getSectionInfo() {
		return sectionInfo;
	}

	public void setSectionInfo(AsopSectionInfo sectionInfo) {
		this.sectionInfo = sectionInfo;
	}

	
	

}
