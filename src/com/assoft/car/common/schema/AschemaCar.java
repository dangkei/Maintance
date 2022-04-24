package com.assoft.car.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//用车
public class AschemaCar extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String reasonContent;//事由  
      private String note;//备注  
      private String useDate;//拟使用时间  
      private String applyDeptName;//申请部门  
      private String throughUser;//经办人  
      private String createLoginName;//创建人  
      private List<String> receivedUsers;//已办人  
      private String dealRes;//办理结果  
      private Integer copies;//份数  
      private List<String> recipients;//待收人员  NOTE：当前处于待办状态的人员
      private String carType;//车型  small:小型轿车 middle:中型轿车 big:大型轿车 
      private String carTypeName;//车型  small:小型轿车 middle:中型轿车 big:大型轿车 名称
      private String usePerson;//乘车人员名单  
      private String carStatus;//车辆情况  
      private String status;//状态  0:办理中 1:通过 2:驳回 
      private String statusName;//状态  0:办理中 1:通过 2:驳回 名称
      private String isFinish;//是否完成  1:是 0:否 
      private String isFinishName;//是否完成  1:是 0:否 名称
      private String startTime;//开始时间  
      private String endTime;//结束时间  
      private String carInfo;//车辆信息  
   
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
      public String getCarType(){
    	return carType;
      }
      public void setCarType(String carType){
    	this.carType=carType;
	   }
      public String getCarTypeName(){
    	return carTypeName;
      }
      public void setCarTypeName(String carTypeName){
    	this.carTypeName=carTypeName;
	   }
      public String getUsePerson(){
    	return usePerson;
      }
      public void setUsePerson(String usePerson){
    	this.usePerson=usePerson;
	   }
      public String getCarStatus(){
    	return carStatus;
      }
      public void setCarStatus(String carStatus){
    	this.carStatus=carStatus;
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
      public String getStartTime(){
    	return startTime;
      }
      public void setStartTime(String startTime){
    	this.startTime=startTime;
	   }
      public String getEndTime(){
    	return endTime;
      }
      public void setEndTime(String endTime){
    	this.endTime=endTime;
	   }
      public String getCarInfo(){
    	return carInfo;
      }
      public void setCarInfo(String carInfo){
    	this.carInfo=carInfo;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("reasonContent",getReasonContent());
            map.put("note",getNote());
            map.put("useDate",getUseDate());
            map.put("applyDeptName",getApplyDeptName());
            map.put("throughUser",getThroughUser());
            map.put("createLoginName",getCreateLoginName());
            map.put("receivedUsers",getReceivedUsers());
            map.put("dealRes",getDealRes());
            map.put("copies",getCopies());
            map.put("recipients",getRecipients());
            map.put("carType",getCarType());
            map.put("carTypeName",getCarTypeName());
            map.put("usePerson",getUsePerson());
            map.put("carStatus",getCarStatus());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("isFinish",getIsFinish());
            map.put("isFinishName",getIsFinishName());
            map.put("startTime",getStartTime());
            map.put("endTime",getEndTime());
            map.put("carInfo",getCarInfo());
      }
  

  @Override
  public String schemaName() {

		return "car";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
