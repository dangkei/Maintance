package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//平台角色
public class AschemaRole extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String name;//名称  
      private String shortName;//短名  
      private String roleType;//角色类别  system:系统管理 security:安全管理 audit:审计管理 
      private String roleTypeName;//角色类别  system:系统管理 security:安全管理 audit:审计管理 名称
      private List<String> deptScope;//用户部门范围  
      private String note;//备注  
   
      public String getName(){
    	return name;
      }
      public void setName(String name){
    	this.name=name;
	   }
      public String getShortName(){
    	return shortName;
      }
      public void setShortName(String shortName){
    	this.shortName=shortName;
	   }
      public String getRoleType(){
    	return roleType;
      }
      public void setRoleType(String roleType){
    	this.roleType=roleType;
	   }
      public String getRoleTypeName(){
    	return roleTypeName;
      }
      public void setRoleTypeName(String roleTypeName){
    	this.roleTypeName=roleTypeName;
	   }
      public List<String> getDeptScope(){
    	return deptScope;
      }
      public void setDeptScope(List<String> deptScope){
    	this.deptScope=deptScope;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("name",getName());
            map.put("shortName",getShortName());
            map.put("roleType",getRoleType());
            map.put("roleTypeName",getRoleTypeName());
            map.put("deptScope",getDeptScope());
            map.put("note",getNote());
      }
  

  @Override
  public String schemaName() {

		return "role";
	}
	 @Override
  public  String schemaType() {

		return "1";
	}
}
