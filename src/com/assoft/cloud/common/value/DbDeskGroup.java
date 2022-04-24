package com.assoft.cloud.common.value;

import java.util.List;


/**
 * 入库的服务组信息存储
 * @author wzj
 */
public class DbDeskGroup  extends DeskItem  {


	private static final long serialVersionUID = 1L;

	private List<String> serviceList;
	private int pos;
	
	private String name;

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<String> serviceList) {
		this.serviceList = serviceList;
	}
	
    

}
