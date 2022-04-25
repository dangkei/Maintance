package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//权限
public class AschemaPermission extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String roleId;//所属平台角色  
      private String operation;//权限操作  dept:部门管理 group:用户组管理 role:平台角色管理 appservice:应用服务管理 approle:应用角色管理 log:日志管理 
      private String operationName;//权限操作  dept:部门管理 group:用户组管理 role:平台角色管理 appservice:应用服务管理 approle:应用角色管理 log:日志管理 名称
      private List<String> roleScope;//角色范围  
      private List<String> deptScope;//部门范围  
      private List<String> groupScope;//工作群范围  
      private List<String> appScope;//应用类别范围  
      private String note;//备注  
   
      public String getRoleId(){
    	return roleId;
      }
      public void setRoleId(String roleId){
    	this.roleId=roleId;
	   }
      public String getOperation(){
    	return operation;
      }
      public void setOperation(String operation){
    	this.operation=operation;
	   }
      public String getOperationName(){
    	return operationName;
      }
      public void setOperationName(String operationName){
    	this.operationName=operationName;
	   }
      public List<String> getRoleScope(){
    	return roleScope;
      }
      public void setRoleScope(List<String> roleScope){
    	this.roleScope=roleScope;
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
      public List<String> getAppScope(){
    	return appScope;
      }
      public void setAppScope(List<String> appScope){
    	this.appScope=appScope;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("roleId",getRoleId());
            map.put("operation",getOperation());
            map.put("operationName",getOperationName());
            map.put("roleScope",getRoleScope());
            map.put("deptScope",getDeptScope());
            map.put("groupScope",getGroupScope());
            map.put("appScope",getAppScope());
            map.put("note",getNote());
      }
  

  @Override
  public String schemaName() {

		return "permission";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
