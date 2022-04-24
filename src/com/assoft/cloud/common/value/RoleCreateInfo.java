package com.assoft.cloud.common.value;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaPermission;
import com.assoft.cloud.common.schema.AschemaRole;

public class RoleCreateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AschemaRole role;
	
	private List<AschemaPermission> remainPermissions;

	public AschemaRole getRole() {
		return role;
	}

	

	public void setRole(AschemaRole role) {
		this.role = role;
	}



	public List<AschemaPermission> getRemainPermissions() {
		return remainPermissions;
	}



	public void setRemainPermissions(List<AschemaPermission> remainPermissions) {
		this.remainPermissions = remainPermissions;
	}

	

}
