package com.assoft.cloud.common.form;

import java.io.Serializable;



import java.util.List;

import com.assoft.cloud.common.schema.AschemaAuthScope;
import com.assoft.cloud.common.schema.AschemaService;

/**
 * 服务表单
 * @author wzj
 *
 */
public class ServiceForm implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private AschemaService service;
	
	private List<String> opdeptName;//面向部门
    private List<String> opgroupName;//面向用户组
    private List<String> opuserName;//面向用户
	
    
    private List<String> serviceTypeNames;
	private int authNum;//授权数量
	
	private List<AschemaAuthScope> authList;

	private String appName;
	
	private List<String> roleNames;
	
	public AschemaService getService() {
		return service;
	}

	public void setService(AschemaService service) {
		this.service = service;
	}

	public int getAuthNum() {
		return authNum;
	}

	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}

	public List<AschemaAuthScope> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AschemaAuthScope> authList) {
		this.authList = authList;
	}

	public List<String> getOpuserName() {
		return opuserName;
	}

	public void setOpuserName(List<String> opuserName) {
		this.opuserName = opuserName;
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

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public List<String> getServiceTypeNames() {
		return serviceTypeNames;
	}

	public void setServiceTypeNames(List<String> serviceTypeNames) {
		this.serviceTypeNames = serviceTypeNames;
	}

	
	
	

}
