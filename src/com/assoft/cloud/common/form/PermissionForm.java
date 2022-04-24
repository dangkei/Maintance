package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaAppType;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaGroup;
import com.assoft.cloud.common.schema.AschemaPermission;
import com.assoft.cloud.common.schema.AschemaRole;

public class PermissionForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaPermission permission;//权限
	
	private List<AschemaRole> roleScope;
	
	private List<AschemaDept> deptScope;
	
	private List<AschemaGroup> groupScope;
	
	private List<AschemaAppType> appScope;

	public AschemaPermission getPermission() {
		return permission;
	}

	public List<AschemaRole> getRoleScope() {
		return roleScope;
	}

	public List<AschemaDept> getDeptScope() {
		return deptScope;
	}

	public List<AschemaGroup> getGroupScope() {
		return groupScope;
	}

	public List<AschemaAppType> getAppScope() {
		return appScope;
	}

	public void setPermission(AschemaPermission permission) {
		this.permission = permission;
	}

	public void setRoleScope(List<AschemaRole> roleScope) {
		this.roleScope = roleScope;
	}

	public void setDeptScope(List<AschemaDept> deptScope) {
		this.deptScope = deptScope;
	}

	public void setGroupScope(List<AschemaGroup> groupScope) {
		this.groupScope = groupScope;
	}

	public void setAppScope(List<AschemaAppType> appScope) {
		this.appScope = appScope;
	}
	
	
	
	
	
	

}
