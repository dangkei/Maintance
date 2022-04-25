package com.assoft.doc.common.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.doc.common.schema.AschemaMeetingSend;

public class MeetingReceiveForm implements Serializable{
	private static final long serialVersionUID = 6921098733467183892L;

	AschemaMeetingReceive aschemaDocReceive;
	AschemaMeetingSend aschemaDocSend;
	String isReceipt = "0"; //是否回执  0:不回执 1:回执 
	Map<String, String> extMap = new HashMap<String, String>();
	
	public MeetingReceiveForm() {
		super();
	}
	public MeetingReceiveForm(AschemaMeetingReceive aschemaDocReceive, AschemaMeetingSend aschemaDocSend) {
		super();
		this.aschemaDocReceive = aschemaDocReceive;
		this.aschemaDocSend = aschemaDocSend;
	}
	public AschemaMeetingReceive getAschemaDocReceive() {
		return aschemaDocReceive;
	}
	public void setAschemaDocReceive(AschemaMeetingReceive aschemaDocReceive) {
		this.aschemaDocReceive = aschemaDocReceive;
	}
	public AschemaMeetingSend getAschemaDocSend() {
		return aschemaDocSend;
	}
	public void setAschemaDocSend(AschemaMeetingSend aschemaDocSend) {
		this.aschemaDocSend = aschemaDocSend;
	}
	public String getIsReceipt() {
		return isReceipt;
	}
	public void setIsReceipt(String isReceipt) {
		this.isReceipt = isReceipt;
	}
	
}
