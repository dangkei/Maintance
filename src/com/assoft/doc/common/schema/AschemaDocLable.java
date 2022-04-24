package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//公文标签
public class AschemaDocLable extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String loginName;//用户短名  NOTE：用户唯一标识
      private Integer sortVal;//序值  
      private String lable;//公文标签  
   
      public String getLoginName(){
    	return loginName;
      }
      public void setLoginName(String loginName){
    	this.loginName=loginName;
	   }
      public Integer getSortVal(){
    	return sortVal;
      }
      public void setSortVal(Integer sortVal){
    	this.sortVal=sortVal;
	   }
      public String getLable(){
    	return lable;
      }
      public void setLable(String lable){
    	this.lable=lable;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("loginName",getLoginName());
            map.put("sortVal",getSortVal());
            map.put("lable",getLable());
      }
  

  @Override
  public String schemaName() {

		return "docLable";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
