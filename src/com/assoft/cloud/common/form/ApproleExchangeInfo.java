package com.assoft.cloud.common.form;

import java.io.Serializable;
import java.util.List;

/**
 * 应用角色
 * @author wzj
 *
 */
public class ApproleExchangeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pos;
	private String roleTitle;//授权角色名称
	private String roleShortname;//授权角色短名
	private String note;//备注
	private List<String> authService;//服务范围短名

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	public String getRoleShortname() {
		return roleShortname;
	}
	public void setRoleShortname(String roleShortname) {
		this.roleShortname = roleShortname;
	}
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	public List<String> getAuthService() {
		return authService;
	}
	public void setAuthService(List<String> authService) {
		this.authService = authService;
	}
	
	
	      
	      

}
