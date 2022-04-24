package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.giss.common.value.AssoftFileObj;

/**
 * 关于用户的导入导出信息
 * @author wzj
 *
 */
public class UserExchangeInfo implements Serializable {

	/**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	

	 private String userName;//姓名
     private String loginName;//登录名
     private String sex;//性别
     private String userStatus;//状态
     private String staffType;//人员类型
     private String staffLevel;//人员级别
     private String security;//安全级别
     private String duty;//职位
     private String phone;//手机号
     private String telephone;//电话
     private String email;//电子邮箱
     private String roomNo;//房间号
     private String ms;//秘书
     private String loginPass;//登录Pass
     private String note;//备注
     private String userTitle;//用户标题
     private String appName;//外部应用
     private String appId;//外部应用标识
	
     private AssoftFileObj portrait;//头像
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getStaffLevel() {
		return staffLevel;
	}
	public void setStaffLevel(String staffLevel) {
		this.staffLevel = staffLevel;
	}
	public AssoftFileObj getPortrait() {
		return portrait;
	}
	public void setPortrait(AssoftFileObj portrait) {
		this.portrait = portrait;
	}
     
     
     

}
