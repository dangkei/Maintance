package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.cloud.common.schema.AschemaGroup;
import com.assoft.cloud.common.schema.AschemaGroupType;

public class GroupForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaGroup group;
	AschemaGroupType groupType;
	
	private int serviceNum;
	
	private int userNum;

	public AschemaGroup getGroup() {
		return group;
	}

	public void setGroup(AschemaGroup group) {
		this.group = group;
	}

	public int getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}

	public AschemaGroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(AschemaGroupType groupType) {
		this.groupType = groupType;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	

}
