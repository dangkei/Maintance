package com.assoft.doc.common.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;

public class DocReceiveForm implements Serializable{
	private static final long serialVersionUID = 6929781733467183892L;

	AschemaDocReceive aschemaDocReceive;
	AschemaDocSend aschemaDocSend;
	String isReceipt = "0"; //是否回执  0:不回执 1:回执 
	Map<String, String> extMap = new HashMap<String, String>();
	
	public DocReceiveForm() {
		super();
	}
	public DocReceiveForm(AschemaDocReceive aschemaDocReceive, AschemaDocSend aschemaDocSend) {
		super();
		this.aschemaDocReceive = aschemaDocReceive;
		this.aschemaDocSend = aschemaDocSend;
	}
	public AschemaDocReceive getAschemaDocReceive() {
		return aschemaDocReceive;
	}
	public void setAschemaDocReceive(AschemaDocReceive aschemaDocReceive) {
		this.aschemaDocReceive = aschemaDocReceive;
	}
	public AschemaDocSend getAschemaDocSend() {
		return aschemaDocSend;
	}
	public void setAschemaDocSend(AschemaDocSend aschemaDocSend) {
		this.aschemaDocSend = aschemaDocSend;
	}
	public String getIsReceipt() {
		return isReceipt;
	}
	public void setIsReceipt(String isReceipt) {
		this.isReceipt = isReceipt;
	}
	public Map<String, String> getExtMap() {
		return extMap;
	}
	public void setExtMap(Map<String, String> extMap) {
		this.extMap = extMap;
	}
	
}
