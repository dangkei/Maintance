package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//签收
public class AschemaReceiveSign extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String docSendId;//制发公文id  
      private String docReceiveId;//接收公文id  
      private String handleTime;//办理时间  
      private String docType;//公文类型  doc:公文 meeting:会议通知 briefing:简报 
      private String docTypeName;//公文类型  doc:公文 meeting:会议通知 briefing:简报 名称
      private String signStatus;//收文状态  1:已签收 0:未签收 2:已撤回 3:已退回 
      private String signStatusName;//收文状态  1:已签收 0:未签收 2:已撤回 3:已退回 名称
      private String signUnit;//待收单位  
      private String signUnitName;//待收单位  名称
      private String signUnitFullName;//待收单位  全称
      private String signUser;//签收人  
      private String signUserName;//签收人  名称
   
      public String getDocSendId(){
    	return docSendId;
      }
      public void setDocSendId(String docSendId){
    	this.docSendId=docSendId;
	   }
      public String getDocReceiveId(){
    	return docReceiveId;
      }
      public void setDocReceiveId(String docReceiveId){
    	this.docReceiveId=docReceiveId;
	   }
      public String getHandleTime(){
    	return handleTime;
      }
      public void setHandleTime(String handleTime){
    	this.handleTime=handleTime;
	   }
      public String getDocType(){
    	return docType;
      }
      public void setDocType(String docType){
    	this.docType=docType;
	   }
      public String getDocTypeName(){
    	return docTypeName;
      }
      public void setDocTypeName(String docTypeName){
    	this.docTypeName=docTypeName;
	   }
      public String getSignStatus(){
    	return signStatus;
      }
      public void setSignStatus(String signStatus){
    	this.signStatus=signStatus;
	   }
      public String getSignStatusName(){
    	return signStatusName;
      }
      public void setSignStatusName(String signStatusName){
    	this.signStatusName=signStatusName;
	   }
      public String getSignUnit(){
    	return signUnit;
      }
      public void setSignUnit(String signUnit){
    	this.signUnit=signUnit;
	   }
      public String getSignUnitName(){
    	return signUnitName;
      }
      public void setSignUnitName(String signUnitName){
    	this.signUnitName=signUnitName;
	   }
      public String getSignUnitFullName(){
    	return signUnitFullName;
      }
      public void setSignUnitFullName(String signUnitFullName){
    	this.signUnitFullName=signUnitFullName;
	   }
      public String getSignUser(){
    	return signUser;
      }
      public void setSignUser(String signUser){
    	this.signUser=signUser;
	   }
      public String getSignUserName(){
    	return signUserName;
      }
      public void setSignUserName(String signUserName){
    	this.signUserName=signUserName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("docSendId",getDocSendId());
            map.put("docReceiveId",getDocReceiveId());
            map.put("handleTime",getHandleTime());
            map.put("docType",getDocType());
            map.put("docTypeName",getDocTypeName());
            map.put("signStatus",getSignStatus());
            map.put("signStatusName",getSignStatusName());
            map.put("signUnit",getSignUnit());
            map.put("signUnitName",getSignUnitName());
            map.put("signUnitFullName",getSignUnitFullName());
            map.put("signUser",getSignUser());
            map.put("signUserName",getSignUserName());
      }
  

  @Override
  public String schemaName() {

		return "receiveSign";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
