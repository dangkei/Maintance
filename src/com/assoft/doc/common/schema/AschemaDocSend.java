package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//公文发送
public class AschemaDocSend extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String docTitle;//公文标题  
      private String urgency;//紧急程度  3:平件 2:急件 1:特急 
      private String urgencyName;//紧急程度  3:平件 2:急件 1:特急 名称
      private String sendDate;//发文时间  
      private String docCodeValue;//文号  
      private String dealRes;//办理结果  
      private String secretBasis;//定密依据  
      private String mainSendUnit;//主送机关  
      private String copySendUnit;//抄送机关  
      private String securityDeadline;//保密期限  
      private String securityClassify;//拟定密级  1:无 2:公开 3:敏感 
      private String securityClassifyName;//拟定密级  1:无 2:公开 3:敏感 名称
      private String draftUser;//撰稿人  
      private String draftUserName;//撰稿人  名称
      private String draftUnit;//拟稿部门  
      private String draftUnitName;//拟稿部门  名称
      private String draftUnitFullName;//拟稿部门  全称
      private String auditUser;//审核人  
      private String auditUserName;//审核人  名称
      private String checkUser;//校对人  
      private String checkUserName;//校对人  名称
      private String remarks;//备注信息  
      private List<AssoftFileObj> docBody;//正文  
      private List<AssoftFileObj> docAttach;//附件  
      private List<AssoftFileObj> docBodyFile;//正文预览文件  NOTE：pdf和swf
      private List<AssoftFileObj> docAttachFile;//附件文件预览  NOTE：有pdf和swf文件
      private List<AssoftFileObj> docApprovalFile;//批办单文件  
      private List<AssoftFileObj> docRelationFile;//相关收文  
      private Integer docYear;//年度  
      private String status;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 
      private String statusName;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 名称
      private List<String> receivers;//接收人  
      private List<String> receiversName;//接收人  名称
      private List<String> receivedUser;//已收人员  
      private List<String> receivedUserName;//已收人员  名称
      private List<String> receiveUnit;//接收单位  
      private List<String> receiveUnitName;//接收单位  名称
      private List<String> receiveUnitFullName;//接收单位  全称
      private List<String> receivedUnit;//已收单位  
      private List<String> receivedUnitName;//已收单位  名称
      private List<String> receivedUnitFullName;//已收单位  全称
      private String deadTime;//截止时间  
      private String resultRecycleUnit;//结果回收单位  
      private String isReceipt;//是否回执  0:不回执 1:回执 2:强制回执 
      private String isReceiptName;//是否回执  0:不回执 1:回执 2:强制回执 名称
      private String sendDocType;//发文类型  1:部门发文 2:人员发文 
      private String sendDocTypeName;//发文类型  1:部门发文 2:人员发文 名称
      private List<String> sendUnit;//发文单位  
      private List<String> sendUnitName;//发文单位  名称
      private List<String> sendUnitFullName;//发文单位  全称
      private List<String> sendUser;//发文人员  
      private List<String> sendUserName;//发文人员  名称
      private String withdraw;//撤回  0:未撤回 1:已撤回 
      private String withdrawName;//撤回  0:未撤回 1:已撤回 名称
      private String proposedOpinions;//拟办意见  
      private String docSourceId;//公文源id  
      private String scanFile;//是否是扫描文件  是:1 否:0 
      private String scanFileName;//是否是扫描文件  是:1 否:0 名称
      private List<String> todoDelUsers;//待办删除人员  
      private List<String> todoDelUsersName;//待办删除人员  名称
      private List<String> doneDelUsers;//已办删除人员  
      private List<String> doneDelUsersName;//已办删除人员  名称
      private List<AssoftFileObj> approvalZip;//正文附件手写签批  
      private String docLable;//来文标签  
   
      public String getDocTitle(){
    	return docTitle;
      }
      public void setDocTitle(String docTitle){
    	this.docTitle=docTitle;
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
      public String getSendDate(){
    	return sendDate;
      }
      public void setSendDate(String sendDate){
    	this.sendDate=sendDate;
	   }
      public String getDocCodeValue(){
    	return docCodeValue;
      }
      public void setDocCodeValue(String docCodeValue){
    	this.docCodeValue=docCodeValue;
	   }
      public String getDealRes(){
    	return dealRes;
      }
      public void setDealRes(String dealRes){
    	this.dealRes=dealRes;
	   }
      public String getSecretBasis(){
    	return secretBasis;
      }
      public void setSecretBasis(String secretBasis){
    	this.secretBasis=secretBasis;
	   }
      public String getMainSendUnit(){
    	return mainSendUnit;
      }
      public void setMainSendUnit(String mainSendUnit){
    	this.mainSendUnit=mainSendUnit;
	   }
      public String getCopySendUnit(){
    	return copySendUnit;
      }
      public void setCopySendUnit(String copySendUnit){
    	this.copySendUnit=copySendUnit;
	   }
      public String getSecurityDeadline(){
    	return securityDeadline;
      }
      public void setSecurityDeadline(String securityDeadline){
    	this.securityDeadline=securityDeadline;
	   }
      public String getSecurityClassify(){
    	return securityClassify;
      }
      public void setSecurityClassify(String securityClassify){
    	this.securityClassify=securityClassify;
	   }
      public String getSecurityClassifyName(){
    	return securityClassifyName;
      }
      public void setSecurityClassifyName(String securityClassifyName){
    	this.securityClassifyName=securityClassifyName;
	   }
      public String getDraftUser(){
    	return draftUser;
      }
      public void setDraftUser(String draftUser){
    	this.draftUser=draftUser;
	   }
      public String getDraftUserName(){
    	return draftUserName;
      }
      public void setDraftUserName(String draftUserName){
    	this.draftUserName=draftUserName;
	   }
      public String getDraftUnit(){
    	return draftUnit;
      }
      public void setDraftUnit(String draftUnit){
    	this.draftUnit=draftUnit;
	   }
      public String getDraftUnitName(){
    	return draftUnitName;
      }
      public void setDraftUnitName(String draftUnitName){
    	this.draftUnitName=draftUnitName;
	   }
      public String getDraftUnitFullName(){
    	return draftUnitFullName;
      }
      public void setDraftUnitFullName(String draftUnitFullName){
    	this.draftUnitFullName=draftUnitFullName;
	   }
      public String getAuditUser(){
    	return auditUser;
      }
      public void setAuditUser(String auditUser){
    	this.auditUser=auditUser;
	   }
      public String getAuditUserName(){
    	return auditUserName;
      }
      public void setAuditUserName(String auditUserName){
    	this.auditUserName=auditUserName;
	   }
      public String getCheckUser(){
    	return checkUser;
      }
      public void setCheckUser(String checkUser){
    	this.checkUser=checkUser;
	   }
      public String getCheckUserName(){
    	return checkUserName;
      }
      public void setCheckUserName(String checkUserName){
    	this.checkUserName=checkUserName;
	   }
      public String getRemarks(){
    	return remarks;
      }
      public void setRemarks(String remarks){
    	this.remarks=remarks;
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
      public List<String> getReceivers(){
    	return receivers;
      }
      public void setReceivers(List<String> receivers){
    	this.receivers=receivers;
	   }
      public List<String> getReceiversName(){
    	return receiversName;
      }
      public void setReceiversName(List<String> receiversName){
    	this.receiversName=receiversName;
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
      public List<String> getReceiveUnit(){
    	return receiveUnit;
      }
      public void setReceiveUnit(List<String> receiveUnit){
    	this.receiveUnit=receiveUnit;
	   }
      public List<String> getReceiveUnitName(){
    	return receiveUnitName;
      }
      public void setReceiveUnitName(List<String> receiveUnitName){
    	this.receiveUnitName=receiveUnitName;
	   }
      public List<String> getReceiveUnitFullName(){
    	return receiveUnitFullName;
      }
      public void setReceiveUnitFullName(List<String> receiveUnitFullName){
    	this.receiveUnitFullName=receiveUnitFullName;
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
      public String getDeadTime(){
    	return deadTime;
      }
      public void setDeadTime(String deadTime){
    	this.deadTime=deadTime;
	   }
      public String getResultRecycleUnit(){
    	return resultRecycleUnit;
      }
      public void setResultRecycleUnit(String resultRecycleUnit){
    	this.resultRecycleUnit=resultRecycleUnit;
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
      public List<String> getSendUnit(){
    	return sendUnit;
      }
      public void setSendUnit(List<String> sendUnit){
    	this.sendUnit=sendUnit;
	   }
      public List<String> getSendUnitName(){
    	return sendUnitName;
      }
      public void setSendUnitName(List<String> sendUnitName){
    	this.sendUnitName=sendUnitName;
	   }
      public List<String> getSendUnitFullName(){
    	return sendUnitFullName;
      }
      public void setSendUnitFullName(List<String> sendUnitFullName){
    	this.sendUnitFullName=sendUnitFullName;
	   }
      public List<String> getSendUser(){
    	return sendUser;
      }
      public void setSendUser(List<String> sendUser){
    	this.sendUser=sendUser;
	   }
      public List<String> getSendUserName(){
    	return sendUserName;
      }
      public void setSendUserName(List<String> sendUserName){
    	this.sendUserName=sendUserName;
	   }
      public String getWithdraw(){
    	return withdraw;
      }
      public void setWithdraw(String withdraw){
    	this.withdraw=withdraw;
	   }
      public String getWithdrawName(){
    	return withdrawName;
      }
      public void setWithdrawName(String withdrawName){
    	this.withdrawName=withdrawName;
	   }
      public String getProposedOpinions(){
    	return proposedOpinions;
      }
      public void setProposedOpinions(String proposedOpinions){
    	this.proposedOpinions=proposedOpinions;
	   }
      public String getDocSourceId(){
    	return docSourceId;
      }
      public void setDocSourceId(String docSourceId){
    	this.docSourceId=docSourceId;
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
      public String getDocLable(){
    	return docLable;
      }
      public void setDocLable(String docLable){
    	this.docLable=docLable;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("docTitle",getDocTitle());
            map.put("urgency",getUrgency());
            map.put("urgencyName",getUrgencyName());
            map.put("sendDate",getSendDate());
            map.put("docCodeValue",getDocCodeValue());
            map.put("dealRes",getDealRes());
            map.put("secretBasis",getSecretBasis());
            map.put("mainSendUnit",getMainSendUnit());
            map.put("copySendUnit",getCopySendUnit());
            map.put("securityDeadline",getSecurityDeadline());
            map.put("securityClassify",getSecurityClassify());
            map.put("securityClassifyName",getSecurityClassifyName());
            map.put("draftUser",getDraftUser());
            map.put("draftUserName",getDraftUserName());
            map.put("draftUnit",getDraftUnit());
            map.put("draftUnitName",getDraftUnitName());
            map.put("draftUnitFullName",getDraftUnitFullName());
            map.put("auditUser",getAuditUser());
            map.put("auditUserName",getAuditUserName());
            map.put("checkUser",getCheckUser());
            map.put("checkUserName",getCheckUserName());
            map.put("remarks",getRemarks());
            map.put("docBody",getDocBody());
            map.put("docAttach",getDocAttach());
            map.put("docBodyFile",getDocBodyFile());
            map.put("docAttachFile",getDocAttachFile());
            map.put("docApprovalFile",getDocApprovalFile());
            map.put("docRelationFile",getDocRelationFile());
            map.put("docYear",getDocYear());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("receivers",getReceivers());
            map.put("receiversName",getReceiversName());
            map.put("receivedUser",getReceivedUser());
            map.put("receivedUserName",getReceivedUserName());
            map.put("receiveUnit",getReceiveUnit());
            map.put("receiveUnitName",getReceiveUnitName());
            map.put("receiveUnitFullName",getReceiveUnitFullName());
            map.put("receivedUnit",getReceivedUnit());
            map.put("receivedUnitName",getReceivedUnitName());
            map.put("receivedUnitFullName",getReceivedUnitFullName());
            map.put("deadTime",getDeadTime());
            map.put("resultRecycleUnit",getResultRecycleUnit());
            map.put("isReceipt",getIsReceipt());
            map.put("isReceiptName",getIsReceiptName());
            map.put("sendDocType",getSendDocType());
            map.put("sendDocTypeName",getSendDocTypeName());
            map.put("sendUnit",getSendUnit());
            map.put("sendUnitName",getSendUnitName());
            map.put("sendUnitFullName",getSendUnitFullName());
            map.put("sendUser",getSendUser());
            map.put("sendUserName",getSendUserName());
            map.put("withdraw",getWithdraw());
            map.put("withdrawName",getWithdrawName());
            map.put("proposedOpinions",getProposedOpinions());
            map.put("docSourceId",getDocSourceId());
            map.put("scanFile",getScanFile());
            map.put("scanFileName",getScanFileName());
            map.put("todoDelUsers",getTodoDelUsers());
            map.put("todoDelUsersName",getTodoDelUsersName());
            map.put("doneDelUsers",getDoneDelUsers());
            map.put("doneDelUsersName",getDoneDelUsersName());
            map.put("approvalZip",getApprovalZip());
            map.put("docLable",getDocLable());
      }
  

  @Override
  public String schemaName() {

		return "docSend";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
