package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//角色授权
public class AschemaAuthScope extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String app;//所属应用  
      private String approle;//所属角色  NOTE：具有的角色
      private List<String> authService;//服务范围  
      private List<String> opdept;//可访问部门  
      private List<String> opgroup;//可访问工作群  
      private List<String> opuser;//特定用户  
      private List<String> opuserName;//特定用户  名称
   
      public String getApp(){
    	return app;
      }
      public void setApp(String app){
    	this.app=app;
	   }
      public String getApprole(){
    	return approle;
      }
      public void setApprole(String approle){
    	this.approle=approle;
	   }
      public List<String> getAuthService(){
    	return authService;
      }
      public void setAuthService(List<String> authService){
    	this.authService=authService;
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
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("app",getApp());
            map.put("approle",getApprole());
            map.put("authService",getAuthService());
            map.put("opdept",getOpdept());
            map.put("opgroup",getOpgroup());
            map.put("opuser",getOpuser());
            map.put("opuserName",getOpuserName());
      }
  

  @Override
  public String schemaName() {

		return "authScope";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
