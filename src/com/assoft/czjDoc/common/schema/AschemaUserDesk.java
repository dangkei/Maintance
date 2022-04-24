package com.assoft.czjDoc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//桌面
public class AschemaUserDesk extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String loginName;//用户  
      private String deskType;//桌面  list:列表 block:块状 
      private String deskTypeName;//桌面  list:列表 block:块状 名称
      private String userName;//用户名  
   
      public String getLoginName(){
    	return loginName;
      }
      public void setLoginName(String loginName){
    	this.loginName=loginName;
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
      public String getUserName(){
    	return userName;
      }
      public void setUserName(String userName){
    	this.userName=userName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("loginName",getLoginName());
            map.put("deskType",getDeskType());
            map.put("deskTypeName",getDeskTypeName());
            map.put("userName",getUserName());
      }
  

  @Override
  public String schemaName() {

		return "userDesk";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
