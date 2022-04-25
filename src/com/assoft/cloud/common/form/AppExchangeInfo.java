package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaApp;


/**
 * 应用
 * @author wzj
 *
 */
public class AppExchangeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AschemaApp app;
	
	List<AppserviceInfo> serviceList;
	
	List<ApproleExchangeInfo> roleinfoList;

	public AschemaApp getApp() {
		return app;
	}

	public void setApp(AschemaApp app) {
		this.app = app;
	}

	public List<AppserviceInfo> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<AppserviceInfo> serviceList) {
		this.serviceList = serviceList;
	}

	public List<ApproleExchangeInfo> getRoleinfoList() {
		return roleinfoList;
	}

	public void setRoleinfoList(List<ApproleExchangeInfo> roleinfoList) {
		this.roleinfoList = roleinfoList;
	}

	
	
	

}
