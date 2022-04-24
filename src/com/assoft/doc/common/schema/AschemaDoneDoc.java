package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//已办公文
public class AschemaDoneDoc extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String docSendId;//制发公文id  
      private String docReceiveId;//接收公文id  
      private String status;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 
      private String statusName;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 名称
      private List<String> receivedUser;//已收人员  
      private List<String> receivedUserName;//已收人员  名称
      private List<String> receivedUnit;//已收单位  
      private List<String> receivedUnitName;//已收单位  名称
      private List<String> receivedUnitFullName;//已收单位  全称
      private String sendDocType;//发文类型  1:部门发文 2:人员发文 
      private String sendDocTypeName;//发文类型  1:部门发文 2:人员发文 名称
      private String docTitle;//标题  
      private String docLable;//来文标签  
      private String handleTime;//办理时间  
      private String sendDate;//发文时间  
      private String urgency;//紧急程度  3:平件 2:急件 1:特急 
      private String urgencyName;//紧急程度  3:平件 2:急件 1:特急 名称
      private String receiveDocType;//办文类型  1:收文 2:发文 
      private String receiveDocTypeName;//办文类型  1:收文 2:发文 名称
      private String docType;//公文类型  doc:公文 meeting:会议通知 briefing:简报 
      private String docTypeName;//公文类型  doc:公文 meeting:会议通知 briefing:简报 名称
      private String scanFile;//是否是扫描文件  是:1 否:0 
      private String scanFileName;//是否是扫描文件  是:1 否:0 名称
      private Integer docYear;//年度  
      private String docNo;//收文编号  
      private String operatorType;//操作类型  1:研提意见 2:对外转发 3:正常完成 
      private String operatorTypeName;//操作类型  1:研提意见 2:对外转发 3:正常完成 名称
      private String fromUnitName;//来文单位  
      private String fromUnitNameName;//来文单位  名称
      private String fromUnitNameFullName;//来文单位  全称
      private String sendUser;//发文人员  
      private String sendUserName;//发文人员  名称
   
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
      public String getStatus(){
    	return status;
      }
      public void setStatus(String status){
    	this.status=status;
	   }
      public String getStatusName(){
    	return statusName;
      }
      public void setStatusName(String statusName){
    	this.statusName=statusName;
	   }
      public List<String> getReceivedUser(){
    	return receivedUser;
      }
      public void setReceivedUser(List<String> receivedUser){
    	this.receivedUser=receivedUser;
	   }
      public List<String> getReceivedUserName(){
    	return receivedUserName;
      }
      public void setReceivedUserName(List<String> receivedUserName){
    	this.receivedUserName=receivedUserName;
	   }
      public List<String> getReceivedUnit(){
    	return receivedUnit;
      }
      public void setReceivedUnit(List<String> receivedUnit){
    	this.receivedUnit=receivedUnit;
	   }
      public List<String> getReceivedUnitName(){
    	return receivedUnitName;
      }
      public void setReceivedUnitName(List<String> receivedUnitName){
    	this.receivedUnitName=receivedUnitName;
	   }
      public List<String> getReceivedUnitFullName(){
    	return receivedUnitFullName;
      }
      public void setReceivedUnitFullName(List<String> receivedUnitFullName){
    	this.receivedUnitFullName=receivedUnitFullName;
	   }
      public String getSendDocType(){
    	return sendDocType;
      }
      public void setSendDocType(String sendDocType){
    	this.sendDocType=sendDocType;
	   }
      public String getSendDocTypeName(){
    	return sendDocTypeName;
      }
      public void setSendDocTypeName(String sendDocTypeName){
    	this.sendDocTypeName=sendDocTypeName;
	   }
      public String getDocTitle(){
    	return docTitle;
      }
      public void setDocTitle(String docTitle){
    	this.docTitle=docTitle;
	   }
      public String getDocLable(){
    	return docLable;
      }
      public void setDocLable(String docLable){
    	this.docLable=docLable;
	   }
      public String getHandleTime(){
    	return handleTime;
      }
      public void setHandleTime(String handleTime){
    	this.handleTime=handleTime;
	   }
      public String getSendDate(){
    	return sendDate;
      }
      public void setSendDate(String sendDate){
    	this.sendDate=sendDate;
	   }
      public String getUrgency(){
    	return urgency;
      }
      public void setUrgency(String urgency){
    	this.urgency=urgency;
	   }
      public String getUrgencyName(){
    	return urgencyName;
      }
      public void setUrgencyName(String urgencyName){
    	this.urgencyName=urgencyName;
	   }
      public String getReceiveDocType(){
    	return receiveDocType;
      }
      public void setReceiveDocType(String receiveDocType){
    	this.receiveDocType=receiveDocType;
	   }
      public String getReceiveDocTypeName(){
    	return receiveDocTypeName;
      }
      public void setReceiveDocTypeName(String receiveDocTypeName){
    	this.receiveDocTypeName=receiveDocTypeName;
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
      public String getScanFile(){
    	return scanFile;
      }
      public void setScanFile(String scanFile){
    	this.scanFile=scanFile;
	   }
      public String getScanFileName(){
    	return scanFileName;
      }
      public void setScanFileName(String scanFileName){
    	this.scanFileName=scanFileName;
	   }
      public Integer getDocYear(){
    	return docYear;
      }
      public void setDocYear(Integer docYear){
    	this.docYear=docYear;
	   }
      public String getDocNo(){
    	return docNo;
      }
      public void setDocNo(String docNo){
    	this.docNo=docNo;
	   }
      public String getOperatorType(){
    	return operatorType;
      }
      public void setOperatorType(String operatorType){
    	this.operatorType=operatorType;
	   }
      public String getOperatorTypeName(){
    	return operatorTypeName;
      }
      public void setOperatorTypeName(String operatorTypeName){
    	this.operatorTypeName=operatorTypeName;
	   }
      public String getFromUnitName(){
    	return fromUnitName;
      }
      public void setFromUnitName(String fromUnitName){
    	this.fromUnitName=fromUnitName;
	   }
      public String getFromUnitNameName(){
    	return fromUnitNameName;
      }
      public void setFromUnitNameName(String fromUnitNameName){
    	this.fromUnitNameName=fromUnitNameName;
	   }
      public String getFromUnitNameFullName(){
    	return fromUnitNameFullName;
      }
      public void setFromUnitNameFullName(String fromUnitNameFullName){
    	this.fromUnitNameFullName=fromUnitNameFullName;
	   }
      public String getSendUser(){
    	return sendUser;
      }
      public void setSendUser(String sendUser){
    	this.sendUser=sendUser;
	   }
      public String getSendUserName(){
    	return sendUserName;
      }
      public void setSendUserName(String sendUserName){
    	this.sendUserName=sendUserName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("docSendId",getDocSendId());
            map.put("docReceiveId",getDocReceiveId());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("receivedUser",getReceivedUser());
            map.put("receivedUserName",getReceivedUserName());
            map.put("receivedUnit",getReceivedUnit());
            map.put("receivedUnitName",getReceivedUnitName());
            map.put("receivedUnitFullName",getReceivedUnitFullName());
            map.put("sendDocType",getSendDocType());
            map.put("sendDocTypeName",getSendDocTypeName());
            map.put("docTitle",getDocTitle());
            map.put("docLable",getDocLable());
            map.put("handleTime",getHandleTime());
            map.put("sendDate",getSendDate());
            map.put("urgency",getUrgency());
            map.put("urgencyName",getUrgencyName());
            map.put("receiveDocType",getReceiveDocType());
            map.put("receiveDocTypeName",getReceiveDocTypeName());
            map.put("docType",getDocType());
            map.put("docTypeName",getDocTypeName());
            map.put("scanFile",getScanFile());
            map.put("scanFileName",getScanFileName());
            map.put("docYear",getDocYear());
            map.put("docNo",getDocNo());
            map.put("operatorType",getOperatorType());
            map.put("operatorTypeName",getOperatorTypeName());
            map.put("fromUnitName",getFromUnitName());
            map.put("fromUnitNameName",getFromUnitNameName());
            map.put("fromUnitNameFullName",getFromUnitNameFullName());
            map.put("sendUser",getSendUser());
            map.put("sendUserName",getSendUserName());
      }
  

  @Override
  public String schemaName() {

		return "doneDoc";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
