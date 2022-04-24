package com.assoft.doc.common.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.assoft.doc.common.schema.AschemaBriefingReceive;
import com.assoft.doc.common.schema.AschemaBriefingSend;

public class BriefingReceiveForm implements Serializable{
	private static final long serialVersionUID = 6929123213892L;

	AschemaBriefingReceive aschemaDocReceive;
	AschemaBriefingSend aschemaDocSend;
	String isReceipt = "0"; //是否回执  0:不回执 1:回执 
	Map<String, String> extMap = new HashMap<String, String>();
	
	public BriefingReceiveForm() {
		super();
	}
	public BriefingReceiveForm(AschemaBriefingReceive aschemaDocReceive, AschemaBriefingSend aschemaDocSend) {
		super();
		this.aschemaDocReceive = aschemaDocReceive;
		this.aschemaDocSend = aschemaDocSend;
	}
	public AschemaBriefingReceive getAschemaDocReceive() {
		return aschemaDocReceive;
	}
	public void setAschemaDocReceive(AschemaBriefingReceive aschemaDocReceive) {
		this.aschemaDocReceive = aschemaDocReceive;
	}
	public AschemaBriefingSend getAschemaDocSend() {
		return aschemaDocSend;
	}
	public void setAschemaDocSend(AschemaBriefingSend aschemaDocSend) {
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
