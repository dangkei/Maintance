package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//自定义分组
public class AschemaCustomGroup extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String groupType;//分组类型  person:人员分组 dept:部门分组 
      private String groupTypeName;//分组类型  person:人员分组 dept:部门分组 名称
      private String groupName;//分组名称  
      private String createLoginName;//创建人  
      private List<String> personList;//人员列表  
      private List<String> personListName;//人员列表  名称
      private List<String> deptList;//部门列表  
      private List<String> deptListName;//部门列表  名称
      private List<String> deptListFullName;//部门列表  全称
      private String groupStatus;//状态  0:正常 1:删除 
      private String groupStatusName;//状态  0:正常 1:删除 名称
   
      public String getGroupType(){
    	return groupType;
      }
      public void setGroupType(String groupType){
    	this.groupType=groupType;
	   }
      public String getGroupTypeName(){
    	return groupTypeName;
      }
      public void setGroupTypeName(String groupTypeName){
    	this.groupTypeName=groupTypeName;
	   }
      public String getGroupName(){
    	return groupName;
      }
      public void setGroupName(String groupName){
    	this.groupName=groupName;
	   }
      public String getCreateLoginName(){
    	return createLoginName;
      }
      public void setCreateLoginName(String createLoginName){
    	this.createLoginName=createLoginName;
	   }
      public List<String> getPersonList(){
    	return personList;
      }
      public void setPersonList(List<String> personList){
    	this.personList=personList;
	   }
      public List<String> getPersonListName(){
    	return personListName;
      }
      public void setPersonListName(List<String> personListName){
    	this.personListName=personListName;
	   }
      public List<String> getDeptList(){
    	return deptList;
      }
      public void setDeptList(List<String> deptList){
    	this.deptList=deptList;
	   }
      public List<String> getDeptListName(){
    	return deptListName;
      }
      public void setDeptListName(List<String> deptListName){
    	this.deptListName=deptListName;
	   }
      public List<String> getDeptListFullName(){
    	return deptListFullName;
      }
      public void setDeptListFullName(List<String> deptListFullName){
    	this.deptListFullName=deptListFullName;
	   }
      public String getGroupStatus(){
    	return groupStatus;
      }
      public void setGroupStatus(String groupStatus){
    	this.groupStatus=groupStatus;
	   }
      public String getGroupStatusName(){
    	return groupStatusName;
      }
      public void setGroupStatusName(String groupStatusName){
    	this.groupStatusName=groupStatusName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("groupType",getGroupType());
            map.put("groupTypeName",getGroupTypeName());
            map.put("groupName",getGroupName());
            map.put("createLoginName",getCreateLoginName());
            map.put("personList",getPersonList());
            map.put("personListName",getPersonListName());
            map.put("deptList",getDeptList());
            map.put("deptListName",getDeptListName());
            map.put("deptListFullName",getDeptListFullName());
            map.put("groupStatus",getGroupStatus());
            map.put("groupStatusName",getGroupStatusName());
      }
  

  @Override
  public String schemaName() {

		return "customGroup";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
