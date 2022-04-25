package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;
import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//用户
public class AschemaUser extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String dept;//所属部门  
      private AssoftFileObj portrait;//头像  
      private String userName;//姓名  
      private String loginName;//登录名  
      private String sex;//性别  0:未知 1:男 2:女 
      private String sexName;//性别  0:未知 1:男 2:女 名称
      private String userStatus;//状态  0:离职 1:在职 
      private String userStatusName;//状态  0:离职 1:在职 名称
      private List<String> group;//所属工作群  
      private List<String> role;//所属角色  
      private String staffType;//人员类型  admin:管理员 receiver:收文员 leader:主管文书工作领导 ordinary:普通人员 
      private String staffTypeName;//人员类型  admin:管理员 receiver:收文员 leader:主管文书工作领导 ordinary:普通人员 名称
      private String staffLevel;//人员级别  1:一般工作人员 2:科室负责人 3:分管领导 4:主要领导 5:区级领导 
      private String staffLevelName;//人员级别  1:一般工作人员 2:科室负责人 3:分管领导 4:主要领导 5:区级领导 名称
      private String idNumber;//身份证号  
      private String entryDate;//入职时间  
      private String duty;//职位  
      private String phone;//手机号  
      private String telephone;//电话  
      private String email;//电子邮箱  
      private String roomNo;//房间号  
      private String ms;//秘书  
      private String msName;//秘书  名称
      private String loginPass;//登录Pass  
      private String userTitle;//用户标题  
      private String appName;//外部应用  
      private String appId;//外部应用标识  
      private String receiveMsg;//是否接收短信  0:不接收 1:接收 
      private String receiveMsgName;//是否接收短信  0:不接收 1:接收 名称
      private String secrecyInfo;//是否保密  1:是 0:否 
      private String secrecyInfoName;//是否保密  1:是 0:否 名称
      private String note;//备注  
      private String userTreeDisplay;//是否在用户树上显示  0:不显示 1:显示 NOTE：0不显示，1或null显示
      private String userTreeDisplayName;//是否在用户树上显示  0:不显示 1:显示 NOTE：0不显示，1或null显示名称
   
      public String getDept(){
    	return dept;
      }
      public void setDept(String dept){
    	this.dept=dept;
	   }
      public AssoftFileObj getPortrait(){
    	return portrait;
      }
      public void setPortrait(AssoftFileObj portrait){
    	this.portrait=portrait;
	   }
      public String getUserName(){
    	return userName;
      }
      public void setUserName(String userName){
    	this.userName=userName;
	   }
      public String getLoginName(){
    	return loginName;
      }
      public void setLoginName(String loginName){
    	this.loginName=loginName;
	   }
      public String getSex(){
    	return sex;
      }
      public void setSex(String sex){
    	this.sex=sex;
	   }
      public String getSexName(){
    	return sexName;
      }
      public void setSexName(String sexName){
    	this.sexName=sexName;
	   }
      public String getUserStatus(){
    	return userStatus;
      }
      public void setUserStatus(String userStatus){
    	this.userStatus=userStatus;
	   }
      public String getUserStatusName(){
    	return userStatusName;
      }
      public void setUserStatusName(String userStatusName){
    	this.userStatusName=userStatusName;
	   }
      public List<String> getGroup(){
    	return group;
      }
      public void setGroup(List<String> group){
    	this.group=group;
	   }
      public List<String> getRole(){
    	return role;
      }
      public void setRole(List<String> role){
    	this.role=role;
	   }
      public String getStaffType(){
    	return staffType;
      }
      public void setStaffType(String staffType){
    	this.staffType=staffType;
	   }
      public String getStaffTypeName(){
    	return staffTypeName;
      }
      public void setStaffTypeName(String staffTypeName){
    	this.staffTypeName=staffTypeName;
	   }
      public String getStaffLevel(){
    	return staffLevel;
      }
      public void setStaffLevel(String staffLevel){
    	this.staffLevel=staffLevel;
	   }
      public String getStaffLevelName(){
    	return staffLevelName;
      }
      public void setStaffLevelName(String staffLevelName){
    	this.staffLevelName=staffLevelName;
	   }
      public String getIdNumber(){
    	return idNumber;
      }
      public void setIdNumber(String idNumber){
    	this.idNumber=idNumber;
	   }
      public String getEntryDate(){
    	return entryDate;
      }
      public void setEntryDate(String entryDate){
    	this.entryDate=entryDate;
	   }
      public String getDuty(){
    	return duty;
      }
      public void setDuty(String duty){
    	this.duty=duty;
	   }
      public String getPhone(){
    	return phone;
      }
      public void setPhone(String phone){
    	this.phone=phone;
	   }
      public String getTelephone(){
    	return telephone;
      }
      public void setTelephone(String telephone){
    	this.telephone=telephone;
	   }
      public String getEmail(){
    	return email;
      }
      public void setEmail(String email){
    	this.email=email;
	   }
      public String getRoomNo(){
    	return roomNo;
      }
      public void setRoomNo(String roomNo){
    	this.roomNo=roomNo;
	   }
      public String getMs(){
    	return ms;
      }
      public void setMs(String ms){
    	this.ms=ms;
	   }
      public String getMsName(){
    	return msName;
      }
      public void setMsName(String msName){
    	this.msName=msName;
	   }
      public String getLoginPass(){
    	return loginPass;
      }
      public void setLoginPass(String loginPass){
    	this.loginPass=loginPass;
	   }
      public String getUserTitle(){
    	return userTitle;
      }
      public void setUserTitle(String userTitle){
    	this.userTitle=userTitle;
	   }
      public String getAppName(){
    	return appName;
      }
      public void setAppName(String appName){
    	this.appName=appName;
	   }
      public String getAppId(){
    	return appId;
      }
      public void setAppId(String appId){
    	this.appId=appId;
	   }
      public String getReceiveMsg(){
    	return receiveMsg;
      }
      public void setReceiveMsg(String receiveMsg){
    	this.receiveMsg=receiveMsg;
	   }
      public String getReceiveMsgName(){
    	return receiveMsgName;
      }
      public void setReceiveMsgName(String receiveMsgName){
    	this.receiveMsgName=receiveMsgName;
	   }
      public String getSecrecyInfo(){
    	return secrecyInfo;
      }
      public void setSecrecyInfo(String secrecyInfo){
    	this.secrecyInfo=secrecyInfo;
	   }
      public String getSecrecyInfoName(){
    	return secrecyInfoName;
      }
      public void setSecrecyInfoName(String secrecyInfoName){
    	this.secrecyInfoName=secrecyInfoName;
	   }
      public String getNote(){
    	return note;
      }
      public void setNote(String note){
    	this.note=note;
	   }
      public String getUserTreeDisplay(){
    	return userTreeDisplay;
      }
      public void setUserTreeDisplay(String userTreeDisplay){
    	this.userTreeDisplay=userTreeDisplay;
	   }
      public String getUserTreeDisplayName(){
    	return userTreeDisplayName;
      }
      public void setUserTreeDisplayName(String userTreeDisplayName){
    	this.userTreeDisplayName=userTreeDisplayName;
	   }
    
  @Override
  public  void fitElements2Map(Map<String, Object> map){
            map.put("dept",getDept());
            map.put("portrait",getPortrait());
            map.put("userName",getUserName());
            map.put("loginName",getLoginName());
            map.put("sex",getSex());
            map.put("sexName",getSexName());
            map.put("userStatus",getUserStatus());
            map.put("userStatusName",getUserStatusName());
            map.put("group",getGroup());
            map.put("role",getRole());
            map.put("staffType",getStaffType());
            map.put("staffTypeName",getStaffTypeName());
            map.put("staffLevel",getStaffLevel());
            map.put("staffLevelName",getStaffLevelName());
            map.put("idNumber",getIdNumber());
            map.put("entryDate",getEntryDate());
            map.put("duty",getDuty());
            map.put("phone",getPhone());
            map.put("telephone",getTelephone());
            map.put("email",getEmail());
            map.put("roomNo",getRoomNo());
            map.put("ms",getMs());
            map.put("msName",getMsName());
            map.put("loginPass",getLoginPass());
            map.put("userTitle",getUserTitle());
            map.put("appName",getAppName());
            map.put("appId",getAppId());
            map.put("receiveMsg",getReceiveMsg());
            map.put("receiveMsgName",getReceiveMsgName());
            map.put("secrecyInfo",getSecrecyInfo());
            map.put("secrecyInfoName",getSecrecyInfoName());
            map.put("note",getNote());
            map.put("userTreeDisplay",getUserTreeDisplay());
            map.put("userTreeDisplayName",getUserTreeDisplayName());
      }
  

  @Override
  public String schemaName() {

		return "user";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
}
