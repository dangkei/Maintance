package com.assoft.chapter.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//用章申请单
public class AschemaChapter extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private Integer number;//盖章个数  
      private List<String> chapterType;//印章类别  officialSeal:公章 financialSeal :财务专用章 invoiceStamp :发票专用章 legalSeal:法人章 unitSeal:单位公章 partyCommitteeSeal:单位党委（组）公章 leaderSeal:主要领导个人名章 otherSeal:其他公章 
      private List<String> chapterTypeName;//印章类别  officialSeal:公章 financialSeal :财务专用章 invoiceStamp :发票专用章 legalSeal:法人章 unitSeal:单位公章 partyCommitteeSeal:单位党委（组）公章 leaderSeal:主要领导个人名章 otherSeal:其他公章 名称
      private String reasonContent;//事由  
      private String note;//备注  
      private String chapterTitle;//需盖章文件标题  
      private String useDate;//拟使用时间  
      private String applyDeptName;//申请部门  
      private String throughUser;//经办人  
      private List<AssoftFileObj> chapterFiles;//用章正文  
      private List<AssoftFileObj> chapterPdfFiles;//用章文件转换  
      private String createLoginName;//创建人  
      private List<String> receivedUsers;//已办人  
      private List<AssoftFileObj> chapterAttach;//用章附件  
      private String dealRes;//办理结果  
      private Integer copies;//用印份数  
      private List<String> recipients;//待收人员  NOTE：当前处于待办状态的人员
      private String status;//状态  0:办理中 1:通过 2:驳回 
      private String statusName;//状态  0:办理中 1:通过 2:驳回 名称
      private String isFinish;//是否完成  1:是 0:否 
      private String isFinishName;//是否完成  1:是 0:否 名称
      private String withdraw;//是否撤回  1:是 0:否 
      private String withdrawName;//是否撤回  1:是 0:否 名称
   
      public Integer getNumber(){
    	return number;
      }
      public void setNumber(Integer number){
    	this.number=number;
	   }
      public List<String> getChapterType(){
    	return chapterType;
      }
      public void setChapterType(List<String> chapterType){
    	this.chapterType=chapterType;
	   }
      public List<String> getChapterTypeName(){
    	return chapterTypeName;
      }
      public void setChapterTypeName(List<String> chapterTypeName){
    	this.chapterTypeName=chapterTypeName;
	   }
      public String getReasonContent(){
    	return reasonContent;
      }
      public void setReasonContent(String reasonContent){
    	this.reasonContent=reasonContent;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
      public String getChapterTitle(){
    	return chapterTitle;
      }
      public void setChapterTitle(String chapterTitle){
    	this.chapterTitle=chapterTitle;
	   }
      public String getUseDate(){
    	return useDate;
      }
      public void setUseDate(String useDate){
    	this.useDate=useDate;
	   }
      public String getApplyDeptName(){
    	return applyDeptName;
      }
      public void setApplyDeptName(String applyDeptName){
    	this.applyDeptName=applyDeptName;
	   }
      public String getThroughUser(){
    	return throughUser;
      }
      public void setThroughUser(String throughUser){
    	this.throughUser=throughUser;
	   }
      public List<AssoftFileObj> getChapterFiles(){
    	return chapterFiles;
      }
      public void setChapterFiles(List<AssoftFileObj> chapterFiles){
    	this.chapterFiles=chapterFiles;
	   }
      public List<AssoftFileObj> getChapterPdfFiles(){
    	return chapterPdfFiles;
      }
      public void setChapterPdfFiles(List<AssoftFileObj> chapterPdfFiles){
    	this.chapterPdfFiles=chapterPdfFiles;
	   }
      public String getCreateLoginName(){
    	return createLoginName;
      }
      public void setCreateLoginName(String createLoginName){
    	this.createLoginName=createLoginName;
	   }
      public List<String> getReceivedUsers(){
    	return receivedUsers;
      }
      public void setReceivedUsers(List<String> receivedUsers){
    	this.receivedUsers=receivedUsers;
	   }
      public List<AssoftFileObj> getChapterAttach(){
    	return chapterAttach;
      }
      public void setChapterAttach(List<AssoftFileObj> chapterAttach){
    	this.chapterAttach=chapterAttach;
	   }
      public String getDealRes(){
    	return dealRes;
      }
      public void setDealRes(String dealRes){
    	this.dealRes=dealRes;
	   }
      public Integer getCopies(){
    	return copies;
      }
      public void setCopies(Integer copies){
    	this.copies=copies;
	   }
      public List<String> getRecipients(){
    	return recipients;
      }
      public void setRecipients(List<String> recipients){
    	this.recipients=recipients;
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
      public String getIsFinish(){
    	return isFinish;
      }
      public void setIsFinish(String isFinish){
    	this.isFinish=isFinish;
	   }
      public String getIsFinishName(){
    	return isFinishName;
      }
      public void setIsFinishName(String isFinishName){
    	this.isFinishName=isFinishName;
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
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("number",getNumber());
            map.put("chapterType",getChapterType());
            map.put("chapterTypeName",getChapterTypeName());
            map.put("reasonContent",getReasonContent());
            map.put("note",getNote());
            map.put("chapterTitle",getChapterTitle());
            map.put("useDate",getUseDate());
            map.put("applyDeptName",getApplyDeptName());
            map.put("throughUser",getThroughUser());
            map.put("chapterFiles",getChapterFiles());
            map.put("chapterPdfFiles",getChapterPdfFiles());
            map.put("createLoginName",getCreateLoginName());
            map.put("receivedUsers",getReceivedUsers());
            map.put("chapterAttach",getChapterAttach());
            map.put("dealRes",getDealRes());
            map.put("copies",getCopies());
            map.put("recipients",getRecipients());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("isFinish",getIsFinish());
            map.put("isFinishName",getIsFinishName());
            map.put("withdraw",getWithdraw());
            map.put("withdrawName",getWithdrawName());
      }
  

  @Override
  public String schemaName() {

		return "chapter";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
