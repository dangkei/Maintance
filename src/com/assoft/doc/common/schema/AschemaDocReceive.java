package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//公文接收
public class AschemaDocReceive extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String docTitle;//标题  
      private String docSendId;//制发公文id  
      private List<String> receiveDeptUnit;//收文单位  
      private List<String> receiveDeptUnitName;//收文单位  名称
      private List<String> receiveDeptUnitFullName;//收文单位  全称
      private List<String> receiveUser;//收文人  
      private List<String> receiveUserName;//收文人  名称
      private String regDate;//登记日期--收文日期  
      private String fromUnitName;//来文单位  
      private String fromUnitNameName;//来文单位  名称
      private String fromUnitNameFullName;//来文单位  全称
      private Integer copies;//印发份数  
      private String remarks;//备注信息  
      private String docLable;//来文标签  
      private String scanFile;//是否是扫描文件  是:1 否:0 
      private String scanFileName;//是否是扫描文件  是:1 否:0 名称
      private String urgency;//紧急程度  3:平件 2:急件 1:特急 
      private String urgencyName;//紧急程度  3:平件 2:急件 1:特急 名称
      private List<AssoftFileObj> docBody;//正文  
      private List<AssoftFileObj> docAttach;//附件  
      private List<AssoftFileObj> docBodyFile;//正文预览文件  NOTE：pdf和swf
      private List<AssoftFileObj> docAttachFile;//附件文件预览  NOTE：有pdf和swf文件
      private List<AssoftFileObj> docApprovalFile;//批办单文件  
      private List<AssoftFileObj> docRelationFile;//相关收文  
      private String docNo;//收文编号  
      private String docCodeValue;//文号  
      private String docCode;//收文号  
      private String dealRes;//办理结果  
      private Integer docYear;//年度  
      private String status;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 
      private String statusName;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 名称
      private String sendDocType;//发文类型  1:部门发文 2:人员发文 
      private String sendDocTypeName;//发文类型  1:部门发文 2:人员发文 名称
      private String sendUser;//发文人员  
      private String sendUserName;//发文人员  名称
      private List<String> receivedUser;//已收人员  
      private List<String> receivedUserName;//已收人员  名称
      private List<String> receivedUnit;//已收单位  
      private List<String> receivedUnitName;//已收单位  名称
      private List<String> receivedUnitFullName;//已收单位  全称
      private String proposedOpinions;//拟办意见  
      private String receipt;//已回执  0:未回执 1:已回执 
      private String receiptName;//已回执  0:未回执 1:已回执 名称
      private String isReceipt;//是否回执  0:不回执 1:回执 2:强制回执 
      private String isReceiptName;//是否回执  0:不回执 1:回执 2:强制回执 名称
      private String receiveDocType;//办文类型  1:收文 2:发文 
      private String receiveDocTypeName;//办文类型  1:收文 2:发文 名称
      private String docSourceId;//公文源id  
      private String sign;//签收  1:已签收 0:未签收 
      private String signName;//签收  1:已签收 0:未签收 名称
      private List<String> withdrawUsers;//撤回人员  
      private List<String> withdrawUsersName;//撤回人员  名称
      private List<String> withdrawDepts;//撤回部门  
      private List<String> withdrawDeptsName;//撤回部门  名称
      private List<String> withdrawDeptsFullName;//撤回部门  全称
      private List<String> backUsers;//退回人员  
      private List<String> backUsersName;//退回人员  名称
      private List<String> backDepts;//退回部门  
      private List<String> backDeptsName;//退回部门  名称
      private List<String> backDeptsFullName;//退回部门  全称
      private List<String> todoDelUsers;//待办删除人员  
      private List<String> todoDelUsersName;//待办删除人员  名称
      private List<String> doneDelUsers;//已办删除人员  
      private List<String> doneDelUsersName;//已办删除人员  名称
      private List<AssoftFileObj> approvalZip;//正文附件手写签批  
   
      public String getDocTitle(){
    	return docTitle;
      }
      public void setDocTitle(String docTitle){
    	this.docTitle=docTitle;
	   }
      public String getDocSendId(){
    	return docSendId;
      }
      public void setDocSendId(String docSendId){
    	this.docSendId=docSendId;
	   }
      public List<String> getReceiveDeptUnit(){
    	return receiveDeptUnit;
      }
      public void setReceiveDeptUnit(List<String> receiveDeptUnit){
    	this.receiveDeptUnit=receiveDeptUnit;
	   }
      public List<String> getReceiveDeptUnitName(){
    	return receiveDeptUnitName;
      }
      public void setReceiveDeptUnitName(List<String> receiveDeptUnitName){
    	this.receiveDeptUnitName=receiveDeptUnitName;
	   }
      public List<String> getReceiveDeptUnitFullName(){
    	return receiveDeptUnitFullName;
      }
      public void setReceiveDeptUnitFullName(List<String> receiveDeptUnitFullName){
    	this.receiveDeptUnitFullName=receiveDeptUnitFullName;
	   }
      public List<String> getReceiveUser(){
    	return receiveUser;
      }
      public void setReceiveUser(List<String> receiveUser){
    	this.receiveUser=receiveUser;
	   }
      public List<String> getReceiveUserName(){
    	return receiveUserName;
      }
      public void setReceiveUserName(List<String> receiveUserName){
    	this.receiveUserName=receiveUserName;
	   }
      public String getRegDate(){
    	return regDate;
      }
      public void setRegDate(String regDate){
    	this.regDate=regDate;
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
      public Integer getCopies(){
    	return copies;
      }
      public void setCopies(Integer copies){
    	this.copies=copies;
	   }
      public String getRemarks(){
    	return remarks;
      }
      public void setRemarks(String remarks){
    	this.remarks=remarks;
	   }
      public String getDocLable(){
    	return docLable;
      }
      public void setDocLable(String docLable){
    	this.docLable=docLable;
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
      public List<AssoftFileObj> getDocBody(){
    	return docBody;
      }
      public void setDocBody(List<AssoftFileObj> docBody){
    	this.docBody=docBody;
	   }
      public List<AssoftFileObj> getDocAttach(){
    	return docAttach;
      }
      public void setDocAttach(List<AssoftFileObj> docAttach){
    	this.docAttach=docAttach;
	   }
      public List<AssoftFileObj> getDocBodyFile(){
    	return docBodyFile;
      }
      public void setDocBodyFile(List<AssoftFileObj> docBodyFile){
    	this.docBodyFile=docBodyFile;
	   }
      public List<AssoftFileObj> getDocAttachFile(){
    	return docAttachFile;
      }
      public void setDocAttachFile(List<AssoftFileObj> docAttachFile){
    	this.docAttachFile=docAttachFile;
	   }
      public List<AssoftFileObj> getDocApprovalFile(){
    	return docApprovalFile;
      }
      public void setDocApprovalFile(List<AssoftFileObj> docApprovalFile){
    	this.docApprovalFile=docApprovalFile;
	   }
      public List<AssoftFileObj> getDocRelationFile(){
    	return docRelationFile;
      }
      public void setDocRelationFile(List<AssoftFileObj> docRelationFile){
    	this.docRelationFile=docRelationFile;
	   }
      public String getDocNo(){
    	return docNo;
      }
      public void setDocNo(String docNo){
    	this.docNo=docNo;
	   }
      public String getDocCodeValue(){
    	return docCodeValue;
      }
      public void setDocCodeValue(String docCodeValue){
    	this.docCodeValue=docCodeValue;
	   }
      public String getDocCode(){
    	return docCode;
      }
      public void setDocCode(String docCode){
    	this.docCode=docCode;
	   }
      public String getDealRes(){
    	return dealRes;
      }
      public void setDealRes(String dealRes){
    	this.dealRes=dealRes;
	   }
      public Integer getDocYear(){
    	return docYear;
      }
      public void setDocYear(Integer docYear){
    	this.docYear=docYear;
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
      public String getProposedOpinions(){
    	return proposedOpinions;
      }
      public void setProposedOpinions(String proposedOpinions){
    	this.proposedOpinions=proposedOpinions;
	   }
      public String getReceipt(){
    	return receipt;
      }
      public void setReceipt(String receipt){
    	this.receipt=receipt;
	   }
      public String getReceiptName(){
    	return receiptName;
      }
      public void setReceiptName(String receiptName){
    	this.receiptName=receiptName;
	   }
      public String getIsReceipt(){
    	return isReceipt;
      }
      public void setIsReceipt(String isReceipt){
    	this.isReceipt=isReceipt;
	   }
      public String getIsReceiptName(){
    	return isReceiptName;
      }
      public void setIsReceiptName(String isReceiptName){
    	this.isReceiptName=isReceiptName;
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
      public String getDocSourceId(){
    	return docSourceId;
      }
      public void setDocSourceId(String docSourceId){
    	this.docSourceId=docSourceId;
	   }
      public String getSign(){
    	return sign;
      }
      public void setSign(String sign){
    	this.sign=sign;
	   }
      public String getSignName(){
    	return signName;
      }
      public void setSignName(String signName){
    	this.signName=signName;
	   }
      public List<String> getWithdrawUsers(){
    	return withdrawUsers;
      }
      public void setWithdrawUsers(List<String> withdrawUsers){
    	this.withdrawUsers=withdrawUsers;
	   }
      public List<String> getWithdrawUsersName(){
    	return withdrawUsersName;
      }
      public void setWithdrawUsersName(List<String> withdrawUsersName){
    	this.withdrawUsersName=withdrawUsersName;
	   }
      public List<String> getWithdrawDepts(){
    	return withdrawDepts;
      }
      public void setWithdrawDepts(List<String> withdrawDepts){
    	this.withdrawDepts=withdrawDepts;
	   }
      public List<String> getWithdrawDeptsName(){
    	return withdrawDeptsName;
      }
      public void setWithdrawDeptsName(List<String> withdrawDeptsName){
    	this.withdrawDeptsName=withdrawDeptsName;
	   }
      public List<String> getWithdrawDeptsFullName(){
    	return withdrawDeptsFullName;
      }
      public void setWithdrawDeptsFullName(List<String> withdrawDeptsFullName){
    	this.withdrawDeptsFullName=withdrawDeptsFullName;
	   }
      public List<String> getBackUsers(){
    	return backUsers;
      }
      public void setBackUsers(List<String> backUsers){
    	this.backUsers=backUsers;
	   }
      public List<String> getBackUsersName(){
    	return backUsersName;
      }
      public void setBackUsersName(List<String> backUsersName){
    	this.backUsersName=backUsersName;
	   }
      public List<String> getBackDepts(){
    	return backDepts;
      }
      public void setBackDepts(List<String> backDepts){
    	this.backDepts=backDepts;
	   }
      public List<String> getBackDeptsName(){
    	return backDeptsName;
      }
      public void setBackDeptsName(List<String> backDeptsName){
    	this.backDeptsName=backDeptsName;
	   }
      public List<String> getBackDeptsFullName(){
    	return backDeptsFullName;
      }
      public void setBackDeptsFullName(List<String> backDeptsFullName){
    	this.backDeptsFullName=backDeptsFullName;
	   }
      public List<String> getTodoDelUsers(){
    	return todoDelUsers;
      }
      public void setTodoDelUsers(List<String> todoDelUsers){
    	this.todoDelUsers=todoDelUsers;
	   }
      public List<String> getTodoDelUsersName(){
    	return todoDelUsersName;
      }
      public void setTodoDelUsersName(List<String> todoDelUsersName){
    	this.todoDelUsersName=todoDelUsersName;
	   }
      public List<String> getDoneDelUsers(){
    	return doneDelUsers;
      }
      public void setDoneDelUsers(List<String> doneDelUsers){
    	this.doneDelUsers=doneDelUsers;
	   }
      public List<String> getDoneDelUsersName(){
    	return doneDelUsersName;
      }
      public void setDoneDelUsersName(List<String> doneDelUsersName){
    	this.doneDelUsersName=doneDelUsersName;
	   }
      public List<AssoftFileObj> getApprovalZip(){
    	return approvalZip;
      }
      public void setApprovalZip(List<AssoftFileObj> approvalZip){
    	this.approvalZip=approvalZip;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("docTitle",getDocTitle());
            map.put("docSendId",getDocSendId());
            map.put("receiveDeptUnit",getReceiveDeptUnit());
            map.put("receiveDeptUnitName",getReceiveDeptUnitName());
            map.put("receiveDeptUnitFullName",getReceiveDeptUnitFullName());
            map.put("receiveUser",getReceiveUser());
            map.put("receiveUserName",getReceiveUserName());
            map.put("regDate",getRegDate());
            map.put("fromUnitName",getFromUnitName());
            map.put("fromUnitNameName",getFromUnitNameName());
            map.put("fromUnitNameFullName",getFromUnitNameFullName());
            map.put("copies",getCopies());
            map.put("remarks",getRemarks());
            map.put("docLable",getDocLable());
            map.put("scanFile",getScanFile());
            map.put("scanFileName",getScanFileName());
            map.put("urgency",getUrgency());
            map.put("urgencyName",getUrgencyName());
            map.put("docBody",getDocBody());
            map.put("docAttach",getDocAttach());
            map.put("docBodyFile",getDocBodyFile());
            map.put("docAttachFile",getDocAttachFile());
            map.put("docApprovalFile",getDocApprovalFile());
            map.put("docRelationFile",getDocRelationFile());
            map.put("docNo",getDocNo());
            map.put("docCodeValue",getDocCodeValue());
            map.put("docCode",getDocCode());
            map.put("dealRes",getDealRes());
            map.put("docYear",getDocYear());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("sendDocType",getSendDocType());
            map.put("sendDocTypeName",getSendDocTypeName());
            map.put("sendUser",getSendUser());
            map.put("sendUserName",getSendUserName());
            map.put("receivedUser",getReceivedUser());
            map.put("receivedUserName",getReceivedUserName());
            map.put("receivedUnit",getReceivedUnit());
            map.put("receivedUnitName",getReceivedUnitName());
            map.put("receivedUnitFullName",getReceivedUnitFullName());
            map.put("proposedOpinions",getProposedOpinions());
            map.put("receipt",getReceipt());
            map.put("receiptName",getReceiptName());
            map.put("isReceipt",getIsReceipt());
            map.put("isReceiptName",getIsReceiptName());
            map.put("receiveDocType",getReceiveDocType());
            map.put("receiveDocTypeName",getReceiveDocTypeName());
            map.put("docSourceId",getDocSourceId());
            map.put("sign",getSign());
            map.put("signName",getSignName());
            map.put("withdrawUsers",getWithdrawUsers());
            map.put("withdrawUsersName",getWithdrawUsersName());
            map.put("withdrawDepts",getWithdrawDepts());
            map.put("withdrawDeptsName",getWithdrawDeptsName());
            map.put("withdrawDeptsFullName",getWithdrawDeptsFullName());
            map.put("backUsers",getBackUsers());
            map.put("backUsersName",getBackUsersName());
            map.put("backDepts",getBackDepts());
            map.put("backDeptsName",getBackDeptsName());
            map.put("backDeptsFullName",getBackDeptsFullName());
            map.put("todoDelUsers",getTodoDelUsers());
            map.put("todoDelUsersName",getTodoDelUsersName());
            map.put("doneDelUsers",getDoneDelUsers());
            map.put("doneDelUsersName",getDoneDelUsersName());
            map.put("approvalZip",getApprovalZip());
      }
  

  @Override
  public String schemaName() {

		return "docReceive";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
