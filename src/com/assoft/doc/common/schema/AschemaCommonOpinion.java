package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//常用意见
public class AschemaCommonOpinion extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String loginName;//用户短名  NOTE：用户唯一标识
      private Integer sortVal;//序值  
      private String opinion;//常用意见  
   
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
      public String getOpinion(){
    	return opinion;
      }
      public void setOpinion(String opinion){
    	this.opinion=opinion;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("loginName",getLoginName());
            map.put("sortVal",getSortVal());
            map.put("opinion",getOpinion());
      }
  

  @Override
  public String schemaName() {

		return "commonOpinion";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
