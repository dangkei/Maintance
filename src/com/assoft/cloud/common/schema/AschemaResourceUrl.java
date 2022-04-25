package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//资源地址
public class AschemaResourceUrl extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String user;//用户  
      private String userName;//用户  名称
      private String resourceName;//名称  
      private String resourcePath;//原始路径  
      private String app;//所属应用  
      private String accessPath;//访问路径  
      private String resourceStatus;//资源状态  1:编辑中 2:已发布 
      private String resourceStatusName;//资源状态  1:编辑中 2:已发布 名称
      private String resourceType;//资源类型  subject:栏目 content:内容 
      private String resourceTypeName;//资源类型  subject:栏目 content:内容 名称
      private String subjectType;//栏目类型  subject:普通栏目 site:网站 sonsite:子网站 
      private String subjectTypeName;//栏目类型  subject:普通栏目 site:网站 sonsite:子网站 名称
      private String loginMode;//登录方式  auto:自动 cloud:平台 
      private String loginModeName;//登录方式  auto:自动 cloud:平台 名称
      private String note;//备注  
   
      public String getUser(){
    	return user;
      }
      public void setUser(String user){
    	this.user=user;
	   }
      public String getUserName(){
    	return userName;
      }
      public void setUserName(String userName){
    	this.userName=userName;
	   }
      public String getResourceName(){
    	return resourceName;
      }
      public void setResourceName(String resourceName){
    	this.resourceName=resourceName;
	   }
      public String getResourcePath(){
    	return resourcePath;
      }
      public void setResourcePath(String resourcePath){
    	this.resourcePath=resourcePath;
	   }
      public String getApp(){
    	return app;
      }
      public void setApp(String app){
    	this.app=app;
	   }
      public String getAccessPath(){
    	return accessPath;
      }
      public void setAccessPath(String accessPath){
    	this.accessPath=accessPath;
	   }
      public String getResourceStatus(){
    	return resourceStatus;
      }
      public void setResourceStatus(String resourceStatus){
    	this.resourceStatus=resourceStatus;
	   }
      public String getResourceStatusName(){
    	return resourceStatusName;
      }
      public void setResourceStatusName(String resourceStatusName){
    	this.resourceStatusName=resourceStatusName;
	   }
      public String getResourceType(){
    	return resourceType;
      }
      public void setResourceType(String resourceType){
    	this.resourceType=resourceType;
	   }
      public String getResourceTypeName(){
    	return resourceTypeName;
      }
      public void setResourceTypeName(String resourceTypeName){
    	this.resourceTypeName=resourceTypeName;
	   }
      public String getSubjectType(){
    	return subjectType;
      }
      public void setSubjectType(String subjectType){
    	this.subjectType=subjectType;
	   }
      public String getSubjectTypeName(){
    	return subjectTypeName;
      }
      public void setSubjectTypeName(String subjectTypeName){
    	this.subjectTypeName=subjectTypeName;
	   }
      public String getLoginMode(){
    	return loginMode;
      }
      public void setLoginMode(String loginMode){
    	this.loginMode=loginMode;
	   }
      public String getLoginModeName(){
    	return loginModeName;
      }
      public void setLoginModeName(String loginModeName){
    	this.loginModeName=loginModeName;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("user",getUser());
            map.put("userName",getUserName());
            map.put("resourceName",getResourceName());
            map.put("resourcePath",getResourcePath());
            map.put("app",getApp());
            map.put("accessPath",getAccessPath());
            map.put("resourceStatus",getResourceStatus());
            map.put("resourceStatusName",getResourceStatusName());
            map.put("resourceType",getResourceType());
            map.put("resourceTypeName",getResourceTypeName());
            map.put("subjectType",getSubjectType());
            map.put("subjectTypeName",getSubjectTypeName());
            map.put("loginMode",getLoginMode());
            map.put("loginModeName",getLoginModeName());
            map.put("note",getNote());
      }
  

  @Override
  public String schemaName() {

		return "resourceUrl";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
