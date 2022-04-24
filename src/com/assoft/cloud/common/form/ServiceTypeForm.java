package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.giss.common.entity.AsopCata;

/**
 * 服务类别
 * @author wzj
 *
 */
public class ServiceTypeForm implements Serializable {

	private AsopCata type;
	
	private int serviceNum;//包含的服务数量
	private int sonCataNum;//子类别数量

	public AsopCata getType() {
		return type;
	}

	public void setType(AsopCata type) {
		this.type = type;
	}

	public int getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}

	public int getSonCataNum() {
		return sonCataNum;
	}

	public void setSonCataNum(int sonCataNum) {
		this.sonCataNum = sonCataNum;
	}
	
	
}
