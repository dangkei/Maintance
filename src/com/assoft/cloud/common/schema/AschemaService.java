package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//服务
public class AschemaService extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String serviceName;//服务名称  
      private String shortName;//短名  
      private List<String> deskType;//桌面类型  pc:PC桌面 phone:手机端 
      private List<String> deskTypeName;//桌面类型  pc:PC桌面 phone:手机端 名称
      private List<String> serviceType;//服务类别  
      private String app;//所属应用  
      private String idsUrl;//认证地址  
      private String accessUrl;//访问地址  
      private String imgType;//图片类别  1:系统图片 2:自定义图片 
      private String imgTypeName;//图片类别  1:系统图片 2:自定义图片 名称
      private String systemImg;//系统图片  NOTE：如果该值为空，则取自定义图片类型
      private AssoftFileObj customImg;//自定义图片  
      private List<String> todoSchema;//待办方案  
      private List<String> opdept;//可访问部门  
      private List<String> opgroup;//可访问工作群  
      private List<String> opuser;//特定用户  
      private List<String> opuserName;//特定用户  名称
      private String status;//服务状态  1:待发布 2:已发布 
      private String statusName;//服务状态  1:待发布 2:已发布 名称
      private String popType;//弹出方式  open:普通打开 fullopen:全屏打开 cloud:平台打开 
      private String popTypeName;//弹出方式  open:普通打开 fullopen:全屏打开 cloud:平台打开 名称
      private String authType;//授权方式  1:按角色授权 2:按用户范围授权 
      private String authTypeName;//授权方式  1:按角色授权 2:按用户范围授权 名称
      private String note;//备注  
   
      public String getServiceName(){
    	return serviceName;
      }
      public void setServiceName(String serviceName){
    	this.serviceName=serviceName;
	   }
      public String getShortName(){
    	return shortName;
      }
      public void setShortName(String shortName){
    	this.shortName=shortName;
	   }
      public List<String> getDeskType(){
    	return deskType;
      }
      public void setDeskType(List<String> deskType){
    	this.deskType=deskType;
	   }
      public List<String> getDeskTypeName(){
    	return deskTypeName;
      }
      public void setDeskTypeName(List<String> deskTypeName){
    	this.deskTypeName=deskTypeName;
	   }
      public List<String> getServiceType(){
    	return serviceType;
      }
      public void setServiceType(List<String> serviceType){
    	this.serviceType=serviceType;
	   }
      public String getApp(){
    	return app;
      }
      public void setApp(String app){
    	this.app=app;
	   }
      public String getIdsUrl(){
    	return idsUrl;
      }
      public void setIdsUrl(String idsUrl){
    	this.idsUrl=idsUrl;
	   }
      public String getAccessUrl(){
    	return accessUrl;
      }
      public void setAccessUrl(String accessUrl){
    	this.accessUrl=accessUrl;
	   }
      public String getImgType(){
    	return imgType;
      }
      public void setImgType(String imgType){
    	this.imgType=imgType;
	   }
      public String getImgTypeName(){
    	return imgTypeName;
      }
      public void setImgTypeName(String imgTypeName){
    	this.imgTypeName=imgTypeName;
	   }
      public String getSystemImg(){
    	return systemImg;
      }
      public void setSystemImg(String systemImg){
    	this.systemImg=systemImg;
	   }
      public AssoftFileObj getCustomImg(){
    	return customImg;
      }
      public void setCustomImg(AssoftFileObj customImg){
    	this.customImg=customImg;
	   }
      public List<String> getTodoSchema(){
    	return todoSchema;
      }
      public void setTodoSchema(List<String> todoSchema){
    	this.todoSchema=todoSchema;
	   }
      public List<String> getOpdept(){
    	return opdept;
      }
      public void setOpdept(List<String> opdept){
    	this.opdept=opdept;
	   }
      public List<String> getOpgroup(){
    	return opgroup;
      }
      public void setOpgroup(List<String> opgroup){
    	this.opgroup=opgroup;
	   }
      public List<String> getOpuser(){
    	return opuser;
      }
      public void setOpuser(List<String> opuser){
    	this.opuser=opuser;
	   }
      public List<String> getOpuserName(){
    	return opuserName;
      }
      public void setOpuserName(List<String> opuserName){
    	this.opuserName=opuserName;
	   }
      public String getStatus(){
    	return status;
      }
      public void setStatus(String status){
    	this.status=status;
	   }
      public String getStatusName(){
    	return statusName;
      }
      public void setStatusName(String statusName){
    	this.statusName=statusName;
	   }
      public String getPopType(){
    	return popType;
      }
      public void setPopType(String popType){
    	this.popType=popType;
	   }
      public String getPopTypeName(){
    	return popTypeName;
      }
      public void setPopTypeName(String popTypeName){
    	this.popTypeName=popTypeName;
	   }
      public String getAuthType(){
    	return authType;
      }
      public void setAuthType(String authType){
    	this.authType=authType;
	   }
      public String getAuthTypeName(){
    	return authTypeName;
      }
      public void setAuthTypeName(String authTypeName){
    	this.authTypeName=authTypeName;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("serviceName",getServiceName());
            map.put("shortName",getShortName());
            map.put("deskType",getDeskType());
            map.put("deskTypeName",getDeskTypeName());
            map.put("serviceType",getServiceType());
            map.put("app",getApp());
            map.put("idsUrl",getIdsUrl());
            map.put("accessUrl",getAccessUrl());
            map.put("imgType",getImgType());
            map.put("imgTypeName",getImgTypeName());
            map.put("systemImg",getSystemImg());
            map.put("customImg",getCustomImg());
            map.put("todoSchema",getTodoSchema());
            map.put("opdept",getOpdept());
            map.put("opgroup",getOpgroup());
            map.put("opuser",getOpuser());
            map.put("opuserName",getOpuserName());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("popType",getPopType());
            map.put("popTypeName",getPopTypeName());
            map.put("authType",getAuthType());
            map.put("authTypeName",getAuthTypeName());
            map.put("note",getNote());
      }
  

  @Override
  public String schemaName() {

		return "service";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
