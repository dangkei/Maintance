package com.assoft.cloud.common.form;

import java.io.Serializable;

import com.assoft.todo.common.schema.AschemaActionRecord;

public class RecordForm implements Serializable {

	AschemaActionRecord actionRecord;
	
	String serviceName;

	public AschemaActionRecord getActionRecord() {
		return actionRecord;
	}

	public void setActionRecord(AschemaActionRecord actionRecord) {
		this.actionRecord = actionRecord;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
}
