package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.cloud.common.schema.AschemaApp;
import com.assoft.cloud.common.schema.AschemaAppType;

public class AppForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AschemaApp app;
	
	private AschemaAppType appType;
	
	private int authNum;//应用授权数量
	
	private int serviceNum;

	private int userAgentNum;//用户代理数量
	public AschemaApp getApp() {
		return app;
	}

	public void setApp(AschemaApp app) {
		this.app = app;
	}

	public int getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}

	public int getAuthNum() {
		return authNum;
	}

	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}

	public AschemaAppType getAppType() {
		return appType;
	}

	public void setAppType(AschemaAppType appType) {
		this.appType = appType;
	}

	public int getUserAgentNum() {
		return userAgentNum;
	}

	public void setUserAgentNum(int userAgentNum) {
		this.userAgentNum = userAgentNum;
	}

	
	
	
}
