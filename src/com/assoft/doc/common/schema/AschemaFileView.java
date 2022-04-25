package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//文件
public class AschemaFileView extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String oldFileName;//原文件名  
      private String filePath;//文件存储路径  
      private String contentType;//文件类型  
      private String fileId;//原文件id  NOTE：到时候可以根据这个找到正文或者附件对应的预览文件（swf和pdf文件）
   
      public String getOldFileName(){
    	return oldFileName;
      }
      public void setOldFileName(String oldFileName){
    	this.oldFileName=oldFileName;
	   }
      public String getFilePath(){
    	return filePath;
      }
      public void setFilePath(String filePath){
    	this.filePath=filePath;
	   }
      public String getContentType(){
    	return contentType;
      }
      public void setContentType(String contentType){
    	this.contentType=contentType;
	   }
      public String getFileId(){
    	return fileId;
      }
      public void setFileId(String fileId){
    	this.fileId=fileId;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("oldFileName",getOldFileName());
            map.put("filePath",getFilePath());
            map.put("contentType",getContentType());
            map.put("fileId",getFileId());
      }
  

  @Override
  public String schemaName() {

		return "fileView";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
