package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//人员列表
public class AschemaPersonTree extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String belongUser;//所属用户  NOTE：这里存用户的登录名
      private List<String> unitIds;//所有单位  
      private List<String> loginNames;//所有人员  
   
      public String getBelongUser(){
    	return belongUser;
      }
      public void setBelongUser(String belongUser){
    	this.belongUser=belongUser;
	   }
      public List<String> getUnitIds(){
    	return unitIds;
      }
      public void setUnitIds(List<String> unitIds){
    	this.unitIds=unitIds;
	   }
      public List<String> getLoginNames(){
    	return loginNames;
      }
      public void setLoginNames(List<String> loginNames){
    	this.loginNames=loginNames;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("belongUser",getBelongUser());
            map.put("unitIds",getUnitIds());
            map.put("loginNames",getLoginNames());
      }
  

  @Override
  public String schemaName() {

		return "personTree";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
