package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaApprole;
import com.assoft.cloud.common.schema.AschemaAuthScope;
import com.assoft.cloud.common.schema.AschemaRole;

/**
 * 
 * @author wzj
 *
 */
public class ApproleForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaApprole approle;
	
	private List<AschemaApprole> fatherRoles;
	
	private AschemaAuthScope authScope;//角色的授权范围

	 private List<String> authServiceName;//服务范围
     private List<String> opdeptName;//面向部门
     private List<String> opgroupName;//面向用户组
     private List<String> opuserName;//面向用户

     private int sonNum;

	public AschemaAuthScope getAuthScope() {
		return authScope;
	}

	public void setAuthScope(AschemaAuthScope authScope) {
		this.authScope = authScope;
	}

	public AschemaApprole getApprole() {
		return approle;
	}

	public void setApprole(AschemaApprole approle) {
		this.approle = approle;
	}

	public List<String> getAuthServiceName() {
		return authServiceName;
	}

	public void setAuthServiceName(List<String> authServiceName) {
		this.authServiceName = authServiceName;
	}

	public List<String> getOpdeptName() {
		return opdeptName;
	}

	public void setOpdeptName(List<String> opdeptName) {
		this.opdeptName = opdeptName;
	}

	public List<String> getOpgroupName() {
		return opgroupName;
	}

	public void setOpgroupName(List<String> opgroupName) {
		this.opgroupName = opgroupName;
	}

	public List<String> getOpuserName() {
		return opuserName;
	}

	public void setOpuserName(List<String> opuserName) {
		this.opuserName = opuserName;
	}

	public int getSonNum() {
		return sonNum;
	}

	public void setSonNum(int sonNum) {
		this.sonNum = sonNum;
	}

	public List<AschemaApprole> getFatherRoles() {
		return fatherRoles;
	}

	public void setFatherRoles(List<AschemaApprole> fatherRoles) {
		this.fatherRoles = fatherRoles;
	}

	
	
	
	
	
	

}
