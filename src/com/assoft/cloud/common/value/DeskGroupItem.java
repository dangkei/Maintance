package com.assoft.cloud.common.value;

import java.util.ArrayList;
import java.util.List;

/**
 * 桌面服务组
 * @author wzj
 *
 */
public class DeskGroupItem  extends DeskItem {


	private static final long serialVersionUID = 1L;

	
	
	private List<DeskServiceItem> serviceList=new ArrayList<DeskServiceItem>();//服务列表
	
    public DeskGroupItem(){
    	this.type="group";
    }

	
	

	public List<DeskServiceItem> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<DeskServiceItem> serviceList) {
		this.serviceList = serviceList;
	}
	
	
	
}
