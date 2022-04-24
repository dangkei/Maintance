package com.assoft.cloud.common.value;

import java.io.Serializable;
import java.util.List;

/**
 * 入库的用户桌面
 * @author wzj
 *
 */
public class DbUserDesk implements Serializable {


	private static final long serialVersionUID = 1L;

	private List<DbDeskService> services;//服务列表
	
	private List<DbDeskGroup> groups;  //服务组
	
	private String mode;//模式
	
	private String skin;//皮肤
	
	private String skinType;//皮肤类型 1系统 2自定义
	

	public List<DbDeskService> getServices() {
		return services;
	}

	public void setServices(List<DbDeskService> services) {
		this.services = services;
	}

	

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public List<DbDeskGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<DbDeskGroup> groups) {
		this.groups = groups;
	}

	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}
	
	
	

	
	
	
	
	
	
}
