package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//应用角色
public class AschemaApprole extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String app;//所属应用  
      private String roleTitle;//角色名称  
      private String roleShortname;//角色短名  
      private String approleType;//角色类型  1:普通角色 2:子角色 
      private String approleTypeName;//角色类型  1:普通角色 2:子角色 名称
      private String note;//备注  
   
      public String getApp(){
    	return app;
      }
      public void setApp(String app){
    	this.app=app;
	   }
      public String getRoleTitle(){
    	return roleTitle;
      }
      public void setRoleTitle(String roleTitle){
    	this.roleTitle=roleTitle;
	   }
      public String getRoleShortname(){
    	return roleShortname;
      }
      public void setRoleShortname(String roleShortname){
    	this.roleShortname=roleShortname;
	   }
      public String getApproleType(){
    	return approleType;
      }
      public void setApproleType(String approleType){
    	this.approleType=approleType;
	   }
      public String getApproleTypeName(){
    	return approleTypeName;
      }
      public void setApproleTypeName(String approleTypeName){
    	this.approleTypeName=approleTypeName;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("app",getApp());
            map.put("roleTitle",getRoleTitle());
            map.put("roleShortname",getRoleShortname());
            map.put("approleType",getApproleType());
            map.put("approleTypeName",getApproleTypeName());
            map.put("note",getNote());
      }
  

  @Override
  public String schemaName() {

		return "approle";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
