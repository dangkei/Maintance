package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//回执
public class AschemaReceiveReceipt extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String docSendId;//制发公文id  
      private String docReceiveId;//接收公文id  
      private String receContent;//回执内容  
      private String receTitle;//回执标题  
      private String receUnit;//回执单位  
      private String receUnitName;//回执单位  名称
      private String receUnitFullName;//回执单位  全称
      private String receUser;//回执人  
      private String receUserName;//回执人  名称
      private String receDate;//回执时间  
      private String receUserTel;//回执人员手机  
      private String receUserOfficeTel;//回执人员办公电话  
      private String docType;//公文类型  doc:公文 meeting:会议通知 briefing:简报 
      private String docTypeName;//公文类型  doc:公文 meeting:会议通知 briefing:简报 名称
      private String receiptIp;//ip地址  
      private String receiptStatus;//回执状态  1:已回执 0:未回执 
      private String receiptStatusName;//回执状态  1:已回执 0:未回执 名称
   
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
      public String getReceContent(){
    	return receContent;
      }
      public void setReceContent(String receContent){
    	this.receContent=receContent;
	   }
      public String getReceTitle(){
    	return receTitle;
      }
      public void setReceTitle(String receTitle){
    	this.receTitle=receTitle;
	   }
      public String getReceUnit(){
    	return receUnit;
      }
      public void setReceUnit(String receUnit){
    	this.receUnit=receUnit;
	   }
      public String getReceUnitName(){
    	return receUnitName;
      }
      public void setReceUnitName(String receUnitName){
    	this.receUnitName=receUnitName;
	   }
      public String getReceUnitFullName(){
    	return receUnitFullName;
      }
      public void setReceUnitFullName(String receUnitFullName){
    	this.receUnitFullName=receUnitFullName;
	   }
      public String getReceUser(){
    	return receUser;
      }
      public void setReceUser(String receUser){
    	this.receUser=receUser;
	   }
      public String getReceUserName(){
    	return receUserName;
      }
      public void setReceUserName(String receUserName){
    	this.receUserName=receUserName;
	   }
      public String getReceDate(){
    	return receDate;
      }
      public void setReceDate(String receDate){
    	this.receDate=receDate;
	   }
      public String getReceUserTel(){
    	return receUserTel;
      }
      public void setReceUserTel(String receUserTel){
    	this.receUserTel=receUserTel;
	   }
      public String getReceUserOfficeTel(){
    	return receUserOfficeTel;
      }
      public void setReceUserOfficeTel(String receUserOfficeTel){
    	this.receUserOfficeTel=receUserOfficeTel;
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
      public String getReceiptIp(){
    	return receiptIp;
      }
      public void setReceiptIp(String receiptIp){
    	this.receiptIp=receiptIp;
	   }
      public String getReceiptStatus(){
    	return receiptStatus;
      }
      public void setReceiptStatus(String receiptStatus){
    	this.receiptStatus=receiptStatus;
	   }
      public String getReceiptStatusName(){
    	return receiptStatusName;
      }
      public void setReceiptStatusName(String receiptStatusName){
    	this.receiptStatusName=receiptStatusName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("docSendId",getDocSendId());
            map.put("docReceiveId",getDocReceiveId());
            map.put("receContent",getReceContent());
            map.put("receTitle",getReceTitle());
            map.put("receUnit",getReceUnit());
            map.put("receUnitName",getReceUnitName());
            map.put("receUnitFullName",getReceUnitFullName());
            map.put("receUser",getReceUser());
            map.put("receUserName",getReceUserName());
            map.put("receDate",getReceDate());
            map.put("receUserTel",getReceUserTel());
            map.put("receUserOfficeTel",getReceUserOfficeTel());
            map.put("docType",getDocType());
            map.put("docTypeName",getDocTypeName());
            map.put("receiptIp",getReceiptIp());
            map.put("receiptStatus",getReceiptStatus());
            map.put("receiptStatusName",getReceiptStatusName());
      }
  

  @Override
  public String schemaName() {

		return "receiveReceipt";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
