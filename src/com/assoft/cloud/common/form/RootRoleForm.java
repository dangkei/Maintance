package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.cloud.common.schema.AschemaRole;

/**
 * 根角色表单
 * @author wzj
 *
 */
public class RootRoleForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AschemaRole rootSystemRole;
	
	private AschemaRole rootSecurityRole;
	
	private AschemaRole rootAuditRole;
	
	
	public String rootSystemDn() {
		if(rootSystemRole!=null) {
			return rootSystemRole.getDn();
		}
		return null;
	}
	
	public String rootSecurityDn() {
		if(rootSecurityRole!=null) {
			return rootSecurityRole.getDn();
		}
		return null;
	}
	
	
	public String rootAuditDn() {
		if(rootAuditRole!=null) {
			return rootAuditRole.getDn();
		}
		return null;
	}
	
	
	
	

	public AschemaRole getRootSystemRole() {
		return rootSystemRole;
	}

	public void setRootSystemRole(AschemaRole rootSystemRole) {
		this.rootSystemRole = rootSystemRole;
	}

	public AschemaRole getRootSecurityRole() {
		return rootSecurityRole;
	}

	public void setRootSecurityRole(AschemaRole rootSecurityRole) {
		this.rootSecurityRole = rootSecurityRole;
	}

	public AschemaRole getRootAuditRole() {
		return rootAuditRole;
	}

	public void setRootAuditRole(AschemaRole rootAuditRole) {
		this.rootAuditRole = rootAuditRole;
	}
	
	
}
