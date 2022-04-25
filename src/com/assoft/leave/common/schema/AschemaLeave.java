package com.assoft.leave.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//请假
public class AschemaLeave extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String leaveApplyUserName;//申请人姓名  
      private String leaveApplyDept;//申请人科室  
      private String leaveType;//请假类别  0:事假 1:病假 2:年休假 3:探亲假 4:生育假 5:婚假 6:丧假 7:其他 8:补休假 9:工伤假 
      private String leaveTypeName;//请假类别  0:事假 1:病假 2:年休假 3:探亲假 4:生育假 5:婚假 6:丧假 7:其他 8:补休假 9:工伤假 名称
      private String leaveReason;//请假事由  
      private String leaveTo;//去向  
      private String leaveContact;//联系方式  
      private String leaveFromDate;//请假时间开始  
      private String leaveToDate;//请假时间结束  
      private String leaveAnnual;//年休假情况  
      private String leaveReportBack;//销假情况  
      private String leaveActual;//实休天数  
      private String leaveRemark;//备注  
      private String createLoginName;//创建人  
      private List<String> receivedUsers;//已收人  
      private List<String> recipients;//待收人  
      private String status;//状态  0:办理中 1:通过 2:驳回 
      private String statusName;//状态  0:办理中 1:通过 2:驳回 名称
      private String leaveTitle;//标题  
      private String isReport;//是否销假  1:是 0:否 2:销假中 
      private String isReportName;//是否销假  1:是 0:否 2:销假中 名称
      private String workTime;//参加工作时间  
      private String role;//职务或职称  
      private String isLeaveBeijing;//是否离京  0:是 1:否 
      private String isLeaveBeijingName;//是否离京  0:是 1:否 名称
      private String zgkSign;//政工科签收存档  
   
      public String getLeaveApplyUserName(){
    	return leaveApplyUserName;
      }
      public void setLeaveApplyUserName(String leaveApplyUserName){
    	this.leaveApplyUserName=leaveApplyUserName;
	   }
      public String getLeaveApplyDept(){
    	return leaveApplyDept;
      }
      public void setLeaveApplyDept(String leaveApplyDept){
    	this.leaveApplyDept=leaveApplyDept;
	   }
      public String getLeaveType(){
    	return leaveType;
      }
      public void setLeaveType(String leaveType){
    	this.leaveType=leaveType;
	   }
      public String getLeaveTypeName(){
    	return leaveTypeName;
      }
      public void setLeaveTypeName(String leaveTypeName){
    	this.leaveTypeName=leaveTypeName;
	   }
      public String getLeaveReason(){
    	return leaveReason;
      }
      public void setLeaveReason(String leaveReason){
    	this.leaveReason=leaveReason;
	   }
      public String getLeaveTo(){
    	return leaveTo;
      }
      public void setLeaveTo(String leaveTo){
    	this.leaveTo=leaveTo;
	   }
      public String getLeaveContact(){
    	return leaveContact;
      }
      public void setLeaveContact(String leaveContact){
    	this.leaveContact=leaveContact;
	   }
      public String getLeaveFromDate(){
    	return leaveFromDate;
      }
      public void setLeaveFromDate(String leaveFromDate){
    	this.leaveFromDate=leaveFromDate;
	   }
      public String getLeaveToDate(){
    	return leaveToDate;
      }
      public void setLeaveToDate(String leaveToDate){
    	this.leaveToDate=leaveToDate;
	   }
      public String getLeaveAnnual(){
    	return leaveAnnual;
      }
      public void setLeaveAnnual(String leaveAnnual){
    	this.leaveAnnual=leaveAnnual;
	   }
      public String getLeaveReportBack(){
    	return leaveReportBack;
      }
      public void setLeaveReportBack(String leaveReportBack){
    	this.leaveReportBack=leaveReportBack;
	   }
      public String getLeaveActual(){
    	return leaveActual;
      }
      public void setLeaveActual(String leaveActual){
    	this.leaveActual=leaveActual;
	   }
      public String getLeaveRemark(){
    	return leaveRemark;
      }
      public void setLeaveRemark(String leaveRemark){
    	this.leaveRemark=leaveRemark;
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
      public String getLeaveTitle(){
    	return leaveTitle;
      }
      public void setLeaveTitle(String leaveTitle){
    	this.leaveTitle=leaveTitle;
	   }
      public String getIsReport(){
    	return isReport;
      }
      public void setIsReport(String isReport){
    	this.isReport=isReport;
	   }
      public String getIsReportName(){
    	return isReportName;
      }
      public void setIsReportName(String isReportName){
    	this.isReportName=isReportName;
	   }
      public String getWorkTime(){
    	return workTime;
      }
      public void setWorkTime(String workTime){
    	this.workTime=workTime;
	   }
      public String getRole(){
    	return role;
      }
      public void setRole(String role){
    	this.role=role;
	   }
      public String getIsLeaveBeijing(){
    	return isLeaveBeijing;
      }
      public void setIsLeaveBeijing(String isLeaveBeijing){
    	this.isLeaveBeijing=isLeaveBeijing;
	   }
      public String getIsLeaveBeijingName(){
    	return isLeaveBeijingName;
      }
      public void setIsLeaveBeijingName(String isLeaveBeijingName){
    	this.isLeaveBeijingName=isLeaveBeijingName;
	   }
      public String getZgkSign(){
    	return zgkSign;
      }
      public void setZgkSign(String zgkSign){
    	this.zgkSign=zgkSign;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("leaveApplyUserName",getLeaveApplyUserName());
            map.put("leaveApplyDept",getLeaveApplyDept());
            map.put("leaveType",getLeaveType());
            map.put("leaveTypeName",getLeaveTypeName());
            map.put("leaveReason",getLeaveReason());
            map.put("leaveTo",getLeaveTo());
            map.put("leaveContact",getLeaveContact());
            map.put("leaveFromDate",getLeaveFromDate());
            map.put("leaveToDate",getLeaveToDate());
            map.put("leaveAnnual",getLeaveAnnual());
            map.put("leaveReportBack",getLeaveReportBack());
            map.put("leaveActual",getLeaveActual());
            map.put("leaveRemark",getLeaveRemark());
            map.put("createLoginName",getCreateLoginName());
            map.put("receivedUsers",getReceivedUsers());
            map.put("recipients",getRecipients());
            map.put("status",getStatus());
            map.put("statusName",getStatusName());
            map.put("leaveTitle",getLeaveTitle());
            map.put("isReport",getIsReport());
            map.put("isReportName",getIsReportName());
            map.put("workTime",getWorkTime());
            map.put("role",getRole());
            map.put("isLeaveBeijing",getIsLeaveBeijing());
            map.put("isLeaveBeijingName",getIsLeaveBeijingName());
            map.put("zgkSign",getZgkSign());
      }
  

  @Override
  public String schemaName() {

		return "leave";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
