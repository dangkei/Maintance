package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//其他分类
public class AschemaOthertype extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String name;//名称  
      private String shortName;//短名  
   
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
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("name",getName());
            map.put("shortName",getShortName());
      }
  

  @Override
  public String schemaName() {

		return "othertype";
	}
	 @Override
  public  String schemaType() {

		return "1";
	}
}
