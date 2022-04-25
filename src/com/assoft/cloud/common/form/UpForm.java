package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.aspweb.common.value.UserProperty;

//import ewebeditor.server.i_jsp;

/**
 * 用户信息
 * @author wzj
 *
 */
public class UpForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String dbPassword;
	
	UserProperty up;
	
	
	public static UpForm buildUpForm(UserProperty up,String dbPassword) {
		UpForm upForm=new UpForm();
		upForm.setUp(up);
		upForm.setDbPassword(dbPassword);
		return upForm;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public UserProperty getUp() {
		return up;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public void setUp(UserProperty up) {
		this.up = up;
	}
	
	

}
