package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

import com.assoft.cloud.common.schema.AschemaUser;

/**
 * 导入导出的部门信息
 * @author wzj
 *
 */
public class DeptExchangeInfo implements Serializable {

  
	 private static final long serialVersionUID = 1L;
	 private String name;//名称
	 
     private String shortName;//短名
     private String deptType;//机构类型  unit:单位 section:部门 sondept:子部门 other:其他 
     
     private String address;//地址  
     private String note;//备注 
     private String leader;//分管领导
     private String manager;//主要负责人
     private List<DeptExchangeInfo> sonDepts;
     
     private List<UserExchangeInfo> users;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public List<DeptExchangeInfo> getSonDepts() {
		return sonDepts;
	}
	public void setSonDepts(List<DeptExchangeInfo> sonDepts) {
		this.sonDepts = sonDepts;
	}
	public List<UserExchangeInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserExchangeInfo> users) {
		this.users = users;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDeptType() {
		return deptType;
	}
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
    
     
    
    
	

	
    
    
    
    
    
}
