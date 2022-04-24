package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

/**
 * 用于导出的应用服务信息（隶属于某个应用）
 * @author wzj
 *
 */
public class AppserviceInfo implements Serializable {

	 private static final long serialVersionUID = 1L;
     private String serviceName;//服务名称
     private String shortName;//短名
     
     
     private List<String> deskType;//桌面类型
     private String popType;//弹出方式
     private String idsUrl;
     private List<String> serviceTypeShortnames;//服务类别对应于服务类别的短名
     private List<String> otherType;//服务其他分类---短名
     private String accessUrl;//访问地址
     private String imgType;//图片类别
     private String authType;
     private String systemImg;//系统图片
     
     private List<String> todoSchema;//待办方案
     private String note;//备注
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public List<String> getDeskType() {
		return deskType;
	}
	public void setDeskType(List<String> deskType) {
		this.deskType = deskType;
	}
	public String getPopType() {
		return popType;
	}
	public void setPopType(String popType) {
		this.popType = popType;
	}
	
	public List<String> getOtherType() {
		return otherType;
	}
	public void setOtherType(List<String> otherType) {
		this.otherType = otherType;
	}

	public String getIdsUrl() {
		return idsUrl;
	}
	public void setIdsUrl(String idsUrl) {
		this.idsUrl = idsUrl;
	}
	public String getAccessUrl() {
		return accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getSystemImg() {
		return systemImg;
	}
	public void setSystemImg(String systemImg) {
		this.systemImg = systemImg;
	}
	
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	public List<String> getTodoSchema() {
		return todoSchema;
	}
	public void setTodoSchema(List<String> todoSchema) {
		this.todoSchema = todoSchema;
	}
	public List<String> getServiceTypeShortnames() {
		return serviceTypeShortnames;
	}
	public void setServiceTypeShortnames(List<String> serviceTypeShortnames) {
		this.serviceTypeShortnames = serviceTypeShortnames;
	}
	
	
}
