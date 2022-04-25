package com.assoft.contract.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//合同
public class AschemaContract extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String note;//备注  
      private String useDate;//日期  
      private String applyDeptName;//业务科室  
      private String throughUser;//经办人  
      private String createLoginName;//创建人  
      private List<String> receivedUsers;//已办人  
      private String dealRes;//办理结果  
      private List<String> recipients;//待收人员  NOTE：当前处于待办状态的人员
      private String contractName;//合同名称  
      private String oppositeUnitName;//对方单位名称  
      private String clauseContent;//主要条款内容  
      private String contractMoney;//合同金额  
      private List<AssoftFileObj> bodyFiles;//正文  
      private List<AssoftFileObj> bodyPdfFiles;//正文转换文件  
      private List<AssoftFileObj> attachFiles;//附件  
      private String status;//状态  0:处理中 1:通过 2:驳回 
      private String statusName;//状态  0:处理中 1:通过 2:驳回 名称
      private String isFinish;//是否完成  1:是 0:否 
      private String isFinishName;//是否完成  1:是 0:否 名称
   
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
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
      public String getDealRes(){
    	return dealRes;
      }
      public void setDealRes(String dealRes){
    	this.dealRes=dealRes;
	   }
      public List<String> getRecipients(){
    	return recipients;
      }
      public void setRecipients(List<String> recipients){
    	this.recipients=recipients;
	   }
      public String getContractName(){
    	return contractName;
      }
      public void setContractName(String contractName){
    	this.contractName=contractName;
	   }
      public String getOppositeUnitName(){
    	return oppositeUnitName;
      }
      public void setOppositeUnitName(String oppositeUnitName){
    	this.oppositeUnitName=oppositeUnitName;
	   }
      public String getClauseContent(){
    	return clauseContent;
      }
      public void setClauseContent(String clauseContent){
    	this.clauseContent=clauseContent;
	   }
      public String getContractMoney(){
    	return contractMoney;
      }
      public void setContractMoney(String contractMoney){
    	this.contractMoney=contractMoney;
	   }
      public List<AssoftFileObj> getBodyFiles(){
    	return bodyFiles;
      }
      public void setBodyFiles(List<AssoftFileObj> bodyFiles){
    	this.bodyFiles=bodyFiles;
	   }
      public List<AssoftFileObj> getBodyPdfFiles(){
    	return bodyPdfFiles;
      }
      public void setBodyPdfFiles(List<AssoftFileObj> bodyPdfFiles){
    	this.bodyPdfFiles=bodyPdfFiles;
	   }
      public List<AssoftFileObj> getAttachFiles(){
    	return attachFiles;
      }
      public void setAttachFiles(List<AssoftFileObj> attachFiles){
    	this.attachFiles=attachFiles;
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
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("note",getNote());
            map.put("useDate",getUseDate());
            map.put("applyDeptName",getApplyDeptName());
            map.put("throughUser",getThroughUser());
            map.put("createLoginName",getCreateLoginName());
            map.put("receivedUsers",getReceivedUsers());
            map.put("dealRes",getDealRes());
            map.put("recipients",getRecipients());
            map.put("contractName",getContractName());
            map.put("oppositeUnitName",getOppositeUnitName());
            map.put("clauseContent",getClauseContent());
            map.put("contractMoney",getContractMoney());
            map.put("bodyFiles",getBodyFiles());
            map.put("bodyPdfFiles",getBodyPdfFiles());
            map.put("attachFiles",getAttachFiles());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("isFinish",getIsFinish());
            map.put("isFinishName",getIsFinishName());
      }
  

  @Override
  public String schemaName() {

		return "contract";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
