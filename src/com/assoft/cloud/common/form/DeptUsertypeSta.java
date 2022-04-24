package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.assoft.cloud.common.schema.AschemaDept;

/**
 * 部门用户统计
 * @author wzj
 *
 */
public class DeptUsertypeSta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaDept dept;
	private int totalNum;
	
	
	private List<UserTypeNum> userTypeNums;

	public AschemaDept getDept() {
		return dept;
	}

	public void setDept(AschemaDept dept) {
		this.dept = dept;
	}

	public List<UserTypeNum> getUserTypeNums() {
		return userTypeNums;
	}

	public void setUserTypeNums(List<UserTypeNum> userTypeNums) {
		this.userTypeNums = userTypeNums;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	
	
	
	
	

	
	

}
