package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//系统信息
public class AschemaSystemInfo extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String systemName;//系统名称  
   
      public String getSystemName(){
    	return systemName;
      }
      public void setSystemName(String systemName){
    	this.systemName=systemName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("systemName",getSystemName());
      }
  

  @Override
  public String schemaName() {

		return "systemInfo";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
