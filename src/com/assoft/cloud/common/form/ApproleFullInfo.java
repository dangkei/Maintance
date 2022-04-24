package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaApp;
import com.assoft.cloud.common.schema.AschemaApprole;

/**
 * 
 * @author wzj
 *
 */
public class ApproleFullInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AschemaApprole approle;
	
	private List<AschemaApprole> fatherRoles;
	
	private AschemaApp app;

	public AschemaApprole getApprole() {
		return approle;
	}

	public List<AschemaApprole> getFatherRoles() {
		return fatherRoles;
	}

	public AschemaApp getApp() {
		return app;
	}

	public void setApprole(AschemaApprole approle) {
		this.approle = approle;
	}

	public void setFatherRoles(List<AschemaApprole> fatherRoles) {
		this.fatherRoles = fatherRoles;
	}

	public void setApp(AschemaApp app) {
		this.app = app;
	}
	
	
	

}
