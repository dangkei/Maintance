package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//机构
public class AschemaDept extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String deptType;//机构类型  unit:单位 section:部门 sondept:子部门 other:其他 
      private String deptTypeName;//机构类型  unit:单位 section:部门 sondept:子部门 other:其他 名称
      private String name;//名称  
      private String fullName;//部门全称  
      private String shortName;//短名  
      private String leader;//分管领导  
      private String leaderName;//分管领导  名称
      private String manager;//负责人  
      private String managerName;//负责人  名称
      private String address;//地址  
      private String appName;//外部应用  
      private String appId;//外部应用标识  
      private String note;//备注  
      private String deptTreeDisplay;//是否在公文部门树上显示  0:不显示 1:显示 NOTE：是否在公文发送页面的部门树上显示，0或null不显示； 1：显示
      private String deptTreeDisplayName;//是否在公文部门树上显示  0:不显示 1:显示 NOTE：是否在公文发送页面的部门树上显示，0或null不显示； 1：显示名称
   
      public String getDeptType(){
    	return deptType;
      }
      public void setDeptType(String deptType){
    	this.deptType=deptType;
	   }
      public String getDeptTypeName(){
    	return deptTypeName;
      }
      public void setDeptTypeName(String deptTypeName){
    	this.deptTypeName=deptTypeName;
	   }
      public String getName(){
    	return name;
      }
      public void setName(String name){
    	this.name=name;
	   }
      public String getFullName(){
    	return fullName;
      }
      public void setFullName(String fullName){
    	this.fullName=fullName;
	   }
      public String getShortName(){
    	return shortName;
      }
      public void setShortName(String shortName){
    	this.shortName=shortName;
	   }
      public String getLeader(){
    	return leader;
      }
      public void setLeader(String leader){
    	this.leader=leader;
	   }
      public String getLeaderName(){
    	return leaderName;
      }
      public void setLeaderName(String leaderName){
    	this.leaderName=leaderName;
	   }
      public String getManager(){
    	return manager;
      }
      public void setManager(String manager){
    	this.manager=manager;
	   }
      public String getManagerName(){
    	return managerName;
      }
      public void setManagerName(String managerName){
    	this.managerName=managerName;
	   }
      public String getAddress(){
    	return address;
      }
      public void setAddress(String address){
    	this.address=address;
	   }
      public String getAppName(){
    	return appName;
      }
      public void setAppName(String appName){
    	this.appName=appName;
	   }
      public String getAppId(){
    	return appId;
      }
      public void setAppId(String appId){
    	this.appId=appId;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
      public String getDeptTreeDisplay(){
    	return deptTreeDisplay;
      }
      public void setDeptTreeDisplay(String deptTreeDisplay){
    	this.deptTreeDisplay=deptTreeDisplay;
	   }
      public String getDeptTreeDisplayName(){
    	return deptTreeDisplayName;
      }
      public void setDeptTreeDisplayName(String deptTreeDisplayName){
    	this.deptTreeDisplayName=deptTreeDisplayName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("deptType",getDeptType());
            map.put("deptTypeName",getDeptTypeName());
            map.put("name",getName());
            map.put("fullName",getFullName());
            map.put("shortName",getShortName());
            map.put("leader",getLeader());
            map.put("leaderName",getLeaderName());
            map.put("manager",getManager());
            map.put("managerName",getManagerName());
            map.put("address",getAddress());
            map.put("appName",getAppName());
            map.put("appId",getAppId());
            map.put("note",getNote());
            map.put("deptTreeDisplay",getDeptTreeDisplay());
            map.put("deptTreeDisplayName",getDeptTreeDisplayName());
      }
  

  @Override
  public String schemaName() {

		return "dept";
	}
	 @Override
  public  String schemaType() {

		return "1";
	}
}
