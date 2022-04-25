package com.assoft.doc.common.form;

import java.io.Serializable;

public class DocReceiveSignForm implements Serializable {
	
	private static final long serialVersionUID = 6158207474436729667L;
	
	private String docReceiveId;
	private String docSendId;
	private String receiveUnit;
	private String receiveUnitName;
	private String status;
	private String createTime;
	private String receiptUser;
	
	public DocReceiveSignForm() {
		super();
	}
	public DocReceiveSignForm(String docReceiveId, String docSendId, String receiveUnit, String receiveUnitName,
			String status, String createTime, String receiptUser) {
		super();
		this.docReceiveId = docReceiveId;
		this.docSendId = docSendId;
		this.receiveUnit = receiveUnit;
		this.receiveUnitName = receiveUnitName;
		this.status = status;
		this.createTime = createTime;
		this.receiptUser = receiptUser;
	}
	public String getDocReceiveId() {
		return docReceiveId;
	}
	public void setDocReceiveId(String docReceiveId) {
		this.docReceiveId = docReceiveId;
	}
	public String getDocSendId() {
		return docSendId;
	}
	public void setDocSendId(String docSendId) {
		this.docSendId = docSendId;
	}
	public String getReceiveUnit() {
		return receiveUnit;
	}
	public void setReceiveUnit(String receiveUnit) {
		this.receiveUnit = receiveUnit;
	}
	public String getReceiveUnitName() {
		return receiveUnitName;
	}
	public void setReceiveUnitName(String receiveUnitName) {
		this.receiveUnitName = receiveUnitName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getReceiptUser() {
		return receiptUser;
	}
	public void setReceiptUser(String receiptUser) {
		this.receiptUser = receiptUser;
	}
	
	
}
