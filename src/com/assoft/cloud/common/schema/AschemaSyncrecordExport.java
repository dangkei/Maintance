package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;

import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//同步导出记录
public class AschemaSyncrecordExport extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String exportTitle;//导出标题
      private String exportUser;//导出用户
      private String exportUserName;//导出用户名称
      private AssoftFileObj appendix;//关联附件
   
      public String getExportTitle(){
    	return exportTitle;
      }
      public void setExportTitle(String exportTitle){
    	this.exportTitle=exportTitle;
	   }
      public String getExportUser(){
    	return exportUser;
      }
      public void setExportUser(String exportUser){
    	this.exportUser=exportUser;
	   }
      public String getExportUserName(){
    	return exportUserName;
      }
      public void setExportUserName(String exportUserName){
    	this.exportUserName=exportUserName;
	   }
      public AssoftFileObj getAppendix(){
    	return appendix;
      }
      public void setAppendix(AssoftFileObj appendix){
    	this.appendix=appendix;
	   }
  
  @Override
  public String schemaName() {

		return "syncrecordExport";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
	@Override
	public void fitElements2Map(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}
}
