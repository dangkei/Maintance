package com.assoft.doc.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//会议制发
public class AschemaMeetingSend extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String docTitle;//标题  
      private String docCodeValue;//文号  
      private String meetingDate;//会议时间  
      private String meetingPlace;//会议地点  
      private String joinLeaders;//参会领导  
      private String meetingContent;//会议主要内容  
      private String joinUnits;//参会单位  
      private String draftUser;//撰稿人  
      private String draftUserName;//撰稿人  名称
      private String draftUnit;//拟稿部门  
      private String draftUnitName;//拟稿部门  名称
      private String draftUnitFullName;//拟稿部门  全称
      private String auditUser;//审核人  
      private String auditUserName;//审核人  名称
      private String checkUser;//校对人  
      private String checkUserName;//校对人  名称
      private String dealRes;//办理结果  
      private String remarks;//备注信息  
      private List<AssoftFileObj> docBody;//正文  
      private List<AssoftFileObj> docAttach;//附件  
      private List<AssoftFileObj> docBodyFile;//正文预览文件  NOTE：pdf和swf
      private List<AssoftFileObj> docAttachFile;//附件文件预览  NOTE：有pdf和swf文件
      private List<AssoftFileObj> docApprovalFile;//批办单文件  
      private String urgency;//紧急程度  3:平件 2:急件 1:特急 
      private String urgencyName;//紧急程度  3:平件 2:急件 1:特急 名称
      private String status;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 
      private String statusName;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 名称
      private String isReceipt;//是否回执  0:不回执 1:回执 2:强制回执 
      private String isReceiptName;//是否回执  0:不回执 1:回执 2:强制回执 名称
      private String sendDocType;//发文类型  1:部门发文 2:人员发文 
      private String sendDocTypeName;//发文类型  1:部门发文 2:人员发文 名称
      private String proposedOpinions;//拟办意见  
      private String receipt;//已回执  0:未回执 1:已回执 
      private String receiptName;//已回执  0:未回执 1:已回执 名称
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
      private List<String> receivers;//接收人  
      private List<String> receiversName;//接收人  名称
      private List<String> receivedUser;//已收人员  
      private List<String> receivedUserName;//已收人员  名称
      private List<String> receivedUnit;//已收单位  
      private List<String> receivedUnitName;//已收单位  名称
      private List<String> receivedUnitFullName;//已收单位  全称
      private List<String> receiveUnit;//接收单位  
      private List<String> receiveUnitName;//接收单位  名称
      private List<String> receiveUnitFullName;//接收单位  全称
      private List<String> sendUnit;//发文单位  
      private List<String> sendUnitName;//发文单位  名称
      private List<String> sendUnitFullName;//发文单位  全称
      private List<String> sendUser;//发文人员  
      private List<String> sendUserName;//发文人员  名称
      private String withdraw;//撤回  0:未撤回 1:已撤回 
      private String withdrawName;//撤回  0:未撤回 1:已撤回 名称
      private String docSourceId;//公文源id  
      private String scanFile;//是否是扫描文件  是:1 否:0 
      private String scanFileName;//是否是扫描文件  是:1 否:0 名称
      private List<String> todoDelUsers;//待办删除人员  
      private List<String> todoDelUsersName;//待办删除人员  名称
      private List<String> doneDelUsers;//已办删除人员  
      private List<String> doneDelUsersName;//已办删除人员  名称
      private String isSendCms;//是否发布到门户  0:否 1:是 
      private String isSendCmsName;//是否发布到门户  0:否 1:是 名称
      private List<AssoftFileObj> approvalZip;//正文附件手写签批  
   
      public String getDocTitle(){
    	return docTitle;
      }
      public void setDocTitle(String docTitle){
    	this.docTitle=docTitle;
	   }
      public String getDocCodeValue(){
    	return docCodeValue;
      }
      public void setDocCodeValue(String docCodeValue){
    	this.docCodeValue=docCodeValue;
	   }
      public String getMeetingDate(){
    	return meetingDate;
      }
      public void setMeetingDate(String meetingDate){
    	this.meetingDate=meetingDate;
	   }
      public String getMeetingPlace(){
    	return meetingPlace;
      }
      public void setMeetingPlace(String meetingPlace){
    	this.meetingPlace=meetingPlace;
	   }
      public String getJoinLeaders(){
    	return joinLeaders;
      }
      public void setJoinLeaders(String joinLeaders){
    	this.joinLeaders=joinLeaders;
	   }
      public String getMeetingContent(){
    	return meetingContent;
      }
      public void setMeetingContent(String meetingContent){
    	this.meetingContent=meetingContent;
	   }
      public String getJoinUnits(){
    	return joinUnits;
      }
      public void setJoinUnits(String joinUnits){
    	this.joinUnits=joinUnits;
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
      public String getDealRes(){
    	return dealRes;
      }
      public void setDealRes(String dealRes){
    	this.dealRes=dealRes;
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
      public String getIsSendCms(){
    	return isSendCms;
      }
      public void setIsSendCms(String isSendCms){
    	this.isSendCms=isSendCms;
	   }
      public String getIsSendCmsName(){
    	return isSendCmsName;
      }
      public void setIsSendCmsName(String isSendCmsName){
    	this.isSendCmsName=isSendCmsName;
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
            map.put("docCodeValue",getDocCodeValue());
            map.put("meetingDate",getMeetingDate());
            map.put("meetingPlace",getMeetingPlace());
            map.put("joinLeaders",getJoinLeaders());
            map.put("meetingContent",getMeetingContent());
            map.put("joinUnits",getJoinUnits());
            map.put("draftUser",getDraftUser());
            map.put("draftUserName",getDraftUserName());
            map.put("draftUnit",getDraftUnit());
            map.put("draftUnitName",getDraftUnitName());
            map.put("draftUnitFullName",getDraftUnitFullName());
            map.put("auditUser",getAuditUser());
            map.put("auditUserName",getAuditUserName());
            map.put("checkUser",getCheckUser());
            map.put("checkUserName",getCheckUserName());
            map.put("dealRes",getDealRes());
            map.put("remarks",getRemarks());
            map.put("docBody",getDocBody());
            map.put("docAttach",getDocAttach());
            map.put("docBodyFile",getDocBodyFile());
            map.put("docAttachFile",getDocAttachFile());
            map.put("docApprovalFile",getDocApprovalFile());
            map.put("urgency",getUrgency());
            map.put("urgencyName",getUrgencyName());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("isReceipt",getIsReceipt());
            map.put("isReceiptName",getIsReceiptName());
            map.put("sendDocType",getSendDocType());
            map.put("sendDocTypeName",getSendDocTypeName());
            map.put("proposedOpinions",getProposedOpinions());
            map.put("receipt",getReceipt());
            map.put("receiptName",getReceiptName());
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
            map.put("receivers",getReceivers());
            map.put("receiversName",getReceiversName());
            map.put("receivedUser",getReceivedUser());
            map.put("receivedUserName",getReceivedUserName());
            map.put("receivedUnit",getReceivedUnit());
            map.put("receivedUnitName",getReceivedUnitName());
            map.put("receivedUnitFullName",getReceivedUnitFullName());
            map.put("receiveUnit",getReceiveUnit());
            map.put("receiveUnitName",getReceiveUnitName());
            map.put("receiveUnitFullName",getReceiveUnitFullName());
            map.put("sendUnit",getSendUnit());
            map.put("sendUnitName",getSendUnitName());
            map.put("sendUnitFullName",getSendUnitFullName());
            map.put("sendUser",getSendUser());
            map.put("sendUserName",getSendUserName());
            map.put("withdraw",getWithdraw());
            map.put("withdrawName",getWithdrawName());
            map.put("docSourceId",getDocSourceId());
            map.put("scanFile",getScanFile());
            map.put("scanFileName",getScanFileName());
            map.put("todoDelUsers",getTodoDelUsers());
            map.put("todoDelUsersName",getTodoDelUsersName());
            map.put("doneDelUsers",getDoneDelUsers());
            map.put("doneDelUsersName",getDoneDelUsersName());
            map.put("isSendCms",getIsSendCms());
            map.put("isSendCmsName",getIsSendCmsName());
            map.put("approvalZip",getApprovalZip());
      }
  

  @Override
  public String schemaName() {

		return "meetingSend";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
