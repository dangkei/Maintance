package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.assoft.cloud.common.schema.AschemaPermission;
import com.assoft.cloud.common.schema.AschemaRole;
import com.assoft.cloud.common.value.UserRoleAuth;

public class RoleForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private AschemaRole role;
	
	private List<AschemaRole> fatherRoles;
	
	
	
	private List<AschemaPermission> permissions;
	
	private int userNum;
	
	private int sonRoleNum;
	
	
    private Map<String, UserRoleAuth> authMap;
	
	

	public AschemaRole getRole() {
		return role;
	}

	public int getUserNum() {
		return userNum;
	}

	public int getSonRoleNum() {
		return sonRoleNum;
	}

	public void setRole(AschemaRole role) {
		this.role = role;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public void setSonRoleNum(int sonRoleNum) {
		this.sonRoleNum = sonRoleNum;
	}

	public List<AschemaRole> getFatherRoles() {
		return fatherRoles;
	}

	public void setFatherRoles(List<AschemaRole> fatherRoles) {
		this.fatherRoles = fatherRoles;
	}

	public List<AschemaPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<AschemaPermission> permissions) {
		this.permissions = permissions;
	}

	public Map<String, UserRoleAuth> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(Map<String, UserRoleAuth> authMap) {
		this.authMap = authMap;
	}
	
	
	
	

}
