package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//应用
public class AschemaApp extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String appType;//应用类别  
      private String appTitle;//应用名称  
      private String appShortname;//应用短名  
      private String idsUrl;//认证地址  
      private List<String> deptScope;//部门范围  
      private List<String> groupScope;//工作群范围  
      private String sync;//是否需要同步  0:不需要 1:需要 
      private String syncName;//是否需要同步  0:不需要 1:需要 名称
      private String syncAddress;//同步地址  
      private String note;//备注  
   
      public String getAppType(){
    	return appType;
      }
      public void setAppType(String appType){
    	this.appType=appType;
	   }
      public String getAppTitle(){
    	return appTitle;
      }
      public void setAppTitle(String appTitle){
    	this.appTitle=appTitle;
	   }
      public String getAppShortname(){
    	return appShortname;
      }
      public void setAppShortname(String appShortname){
    	this.appShortname=appShortname;
	   }
      public String getIdsUrl(){
    	return idsUrl;
      }
      public void setIdsUrl(String idsUrl){
    	this.idsUrl=idsUrl;
	   }
      public List<String> getDeptScope(){
    	return deptScope;
      }
      public void setDeptScope(List<String> deptScope){
    	this.deptScope=deptScope;
	   }
      public List<String> getGroupScope(){
    	return groupScope;
      }
      public void setGroupScope(List<String> groupScope){
    	this.groupScope=groupScope;
	   }
      public String getSync(){
    	return sync;
      }
      public void setSync(String sync){
    	this.sync=sync;
	   }
      public String getSyncName(){
    	return syncName;
      }
      public void setSyncName(String syncName){
    	this.syncName=syncName;
	   }
      public String getSyncAddress(){
    	return syncAddress;
      }
      public void setSyncAddress(String syncAddress){
    	this.syncAddress=syncAddress;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("appType",getAppType());
            map.put("appTitle",getAppTitle());
            map.put("appShortname",getAppShortname());
            map.put("idsUrl",getIdsUrl());
            map.put("deptScope",getDeptScope());
            map.put("groupScope",getGroupScope());
            map.put("sync",getSync());
            map.put("syncName",getSyncName());
            map.put("syncAddress",getSyncAddress());
            map.put("note",getNote());
      }
  

  @Override
  public String schemaName() {

		return "app";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
