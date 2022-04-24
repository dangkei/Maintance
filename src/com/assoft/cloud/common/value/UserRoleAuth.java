package com.assoft.cloud.common.value;

import java.io.Serializable;

public class UserRoleAuth implements Serializable {


	private static final long serialVersionUID = 1L;
	


	
	private boolean userAdmined;//当前用户对该角色是否有管理权，指的是能添加用户，创建子角色

	private boolean permissionAdmined;//当前用户是否能管理权限，前提是能管理当前角色的父角色
	



	public boolean isUserAdmined() {
		return userAdmined;
	}



	public boolean isPermissionAdmined() {
		return permissionAdmined;
	}



	public void setUserAdmined(boolean userAdmined) {
		this.userAdmined = userAdmined;
	}



	public void setPermissionAdmined(boolean permissionAdmined) {
		this.permissionAdmined = permissionAdmined;
	}

	
	
	
	
	
}
