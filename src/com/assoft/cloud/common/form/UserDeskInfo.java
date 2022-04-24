package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.cloud.common.value.UserDesk;
import com.assoft.cloudclient.common.AsopUser;

/**
 * 用户即桌面信息
 * @author wzj
 *
 */
public class UserDeskInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AsopUser userInfo;
	
	private UserDesk desk;
	
	private String  dbPassword;

	public AsopUser getUserInfo() {
		return userInfo;
	}

	public UserDesk getDesk() {
		return desk;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setUserInfo(AsopUser userInfo) {
		this.userInfo = userInfo;
	}

	public void setDesk(UserDesk desk) {
		this.desk = desk;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	
	
	

}
