package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//用户桌面
public class AschemaUserdesk extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String user;//用户  
      private String userName;//用户  名称
      private String deskInfo;//桌面信息  
      private String deskType;//桌面类型  pc:PC桌面 phone:手机端 
      private String deskTypeName;//桌面类型  pc:PC桌面 phone:手机端 名称
      private String deskTitle;//桌面标题  
   
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
      public String getDeskInfo(){
    	return deskInfo;
      }
      public void setDeskInfo(String deskInfo){
    	this.deskInfo=deskInfo;
	   }
      public String getDeskType(){
    	return deskType;
      }
      public void setDeskType(String deskType){
    	this.deskType=deskType;
	   }
      public String getDeskTypeName(){
    	return deskTypeName;
      }
      public void setDeskTypeName(String deskTypeName){
    	this.deskTypeName=deskTypeName;
	   }
      public String getDeskTitle(){
    	return deskTitle;
      }
      public void setDeskTitle(String deskTitle){
    	this.deskTitle=deskTitle;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("user",getUser());
            map.put("userName",getUserName());
            map.put("deskInfo",getDeskInfo());
            map.put("deskType",getDeskType());
            map.put("deskTypeName",getDeskTypeName());
            map.put("deskTitle",getDeskTitle());
      }
  

  @Override
  public String schemaName() {

		return "userdesk";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
