package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//配置信息
public class AschemaConfigData extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String dataTitle;//中文名称  
      private String idName;//英文名称  NOTE：英文名称
      private String type;//类型  str:字符串 int:数字 list:集合 map:对象 
      private String typeName;//类型  str:字符串 int:数字 list:集合 map:对象 名称
      private String value;//值  
      private String description;//描述  
   
      public String getDataTitle(){
    	return dataTitle;
      }
      public void setDataTitle(String dataTitle){
    	this.dataTitle=dataTitle;
	   }
      public String getIdName(){
    	return idName;
      }
      public void setIdName(String idName){
    	this.idName=idName;
	   }
      public String getType(){
    	return type;
      }
      public void setType(String type){
    	this.type=type;
	   }
      public String getTypeName(){
    	return typeName;
      }
      public void setTypeName(String typeName){
    	this.typeName=typeName;
	   }
      public String getValue(){
    	return value;
      }
      public void setValue(String value){
    	this.value=value;
	   }
      public String getDescription(){
    	return description;
      }
      public void setDescription(String description){
    	this.description=description;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("dataTitle",getDataTitle());
            map.put("idName",getIdName());
            map.put("type",getType());
            map.put("typeName",getTypeName());
            map.put("value",getValue());
            map.put("description",getDescription());
      }
  

  @Override
  public String schemaName() {

		return "configData";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
