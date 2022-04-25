package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaRole;

/**
    *    角色名称信息
 * @author wzj
 *
 */
public class RoleFullInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<AschemaRole> fatherRoles;
	
	private AschemaRole role;

	

	public AschemaRole getRole() {
		return role;
	}

	
	public void setRole(AschemaRole role) {
		this.role = role;
	}


	public List<AschemaRole> getFatherRoles() {
		return fatherRoles;
	}


	public void setFatherRoles(List<AschemaRole> fatherRoles) {
		this.fatherRoles = fatherRoles;
	}
	
	

}
