package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//工作群类别
public class AschemaGroupType extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String typeName;//名称  
      private String typeShortname;//短名  
      private String img;//群图片  
      private String typeDes;//描述  
   
      public String getTypeName(){
    	return typeName;
      }
      public void setTypeName(String typeName){
    	this.typeName=typeName;
	   }
      public String getTypeShortname(){
    	return typeShortname;
      }
      public void setTypeShortname(String typeShortname){
    	this.typeShortname=typeShortname;
	   }
      public String getImg(){
    	return img;
      }
      public void setImg(String img){
    	this.img=img;
	   }
      public String getTypeDes(){
    	return typeDes;
      }
      public void setTypeDes(String typeDes){
    	this.typeDes=typeDes;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("typeName",getTypeName());
            map.put("typeShortname",getTypeShortname());
            map.put("img",getImg());
            map.put("typeDes",getTypeDes());
      }
  

  @Override
  public String schemaName() {

		return "groupType";
	}
	 @Override
  public  String schemaType() {

		return "1";
	}
}
