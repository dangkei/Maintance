package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//工作群
public class AschemaGroup extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String groupType;//群类别  
      private String name;//名称  
      private String shortName;//短名  
      private List<String> tag;//标签  
      private List<String> deptScope;//用户部门范围  
      private List<String> users;//包含用户  
      private List<String> usersName;//包含用户  名称
      private List<String> manager;//管理员  
      private List<String> managerName;//管理员  名称
      private List<String> leader;//分管领导  
      private List<String> leaderName;//分管领导  名称
   
      public String getGroupType(){
    	return groupType;
      }
      public void setGroupType(String groupType){
    	this.groupType=groupType;
	   }
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
      public List<String> getTag(){
    	return tag;
      }
      public void setTag(List<String> tag){
    	this.tag=tag;
	   }
      public List<String> getDeptScope(){
    	return deptScope;
      }
      public void setDeptScope(List<String> deptScope){
    	this.deptScope=deptScope;
	   }
      public List<String> getUsers(){
    	return users;
      }
      public void setUsers(List<String> users){
    	this.users=users;
	   }
      public List<String> getUsersName(){
    	return usersName;
      }
      public void setUsersName(List<String> usersName){
    	this.usersName=usersName;
	   }
      public List<String> getManager(){
    	return manager;
      }
      public void setManager(List<String> manager){
    	this.manager=manager;
	   }
      public List<String> getManagerName(){
    	return managerName;
      }
      public void setManagerName(List<String> managerName){
    	this.managerName=managerName;
	   }
      public List<String> getLeader(){
    	return leader;
      }
      public void setLeader(List<String> leader){
    	this.leader=leader;
	   }
      public List<String> getLeaderName(){
    	return leaderName;
      }
      public void setLeaderName(List<String> leaderName){
    	this.leaderName=leaderName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("groupType",getGroupType());
            map.put("name",getName());
            map.put("shortName",getShortName());
            map.put("tag",getTag());
            map.put("deptScope",getDeptScope());
            map.put("users",getUsers());
            map.put("usersName",getUsersName());
            map.put("manager",getManager());
            map.put("managerName",getManagerName());
            map.put("leader",getLeader());
            map.put("leaderName",getLeaderName());
      }
  

  @Override
  public String schemaName() {

		return "group";
	}
	 @Override
  public  String schemaType() {

		return "1";
	}
}
