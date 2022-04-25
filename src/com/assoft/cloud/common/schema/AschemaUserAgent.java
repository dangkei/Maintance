package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//用户代理
public class AschemaUserAgent extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String app;//所属应用  
      private String ppName;//被代理方名称  
      private String ppId;//被代理方标识  
      private List<String> proxyUsers;//代理人员  
      private List<String> proxyUsersName;//代理人员  名称
   
      public String getApp(){
    	return app;
      }
      public void setApp(String app){
    	this.app=app;
	   }
      public String getPpName(){
    	return ppName;
      }
      public void setPpName(String ppName){
    	this.ppName=ppName;
	   }
      public String getPpId(){
    	return ppId;
      }
      public void setPpId(String ppId){
    	this.ppId=ppId;
	   }
      public List<String> getProxyUsers(){
    	return proxyUsers;
      }
      public void setProxyUsers(List<String> proxyUsers){
    	this.proxyUsers=proxyUsers;
	   }
      public List<String> getProxyUsersName(){
    	return proxyUsersName;
      }
      public void setProxyUsersName(List<String> proxyUsersName){
    	this.proxyUsersName=proxyUsersName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("app",getApp());
            map.put("ppName",getPpName());
            map.put("ppId",getPpId());
            map.put("proxyUsers",getProxyUsers());
            map.put("proxyUsersName",getProxyUsersName());
      }
  

  @Override
  public String schemaName() {

		return "userAgent";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
