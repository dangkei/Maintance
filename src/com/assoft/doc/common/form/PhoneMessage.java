package com.assoft.doc.common.form;

import java.io.Serializable;

public class PhoneMessage implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	public static final String ACT_NAME_RECEIVE="ReceiveDoc";
	public static final String ACT_NAME_SEND="SendDoc";
	public static final String DATATYPE_OP_ADD = "1";
	public static final String DATATYPE_OP_OVER = "2";
	public static final String OPTYPE_OPERA="1";
	public static final String OPTYPE_READ="3";
	
	private String actName;					//办文的类型，receive：收文 
	
	private String dataType;				//操作类型，增加1，办结2
	
	private String oid;						//公文主键
	
	private String operators;				//操作人员，登录名
	
	private String opType;					//办理类型，待办1还是待阅3
	
	private String processDefinitionKey;	//流程定义的名称
	
	private String destinationActivityId;	//流程节点的名称
	
	private String accessUnitFullName;//用户所在部门的全称
	
	private String modelName;//收文：空，DocumentSend，information,FileTransfer
	
	private String opinionName;//流程操作名称
	
	private boolean isZhfb=false;//操作人员是否是政府办的
	
	private String formType;//表单类型（新添加的）1或者null：办文2：办会
	
	private String userAccessUnitCode;//接入单位(弃用)
	
	
	public PhoneMessage(){
		
	}

	public PhoneMessage(String actName, String dataType, String oid, String processDefinitionKey) {
		this.actName = actName;
		this.dataType = dataType;
		this.oid = oid;
		this.processDefinitionKey = processDefinitionKey;
	}
	
	
	
	
	
	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getDestinationActivityId() {
		return destinationActivityId;
	}
	
	public void setDestinationActivityId(String destinationActivityId) {
		this.destinationActivityId = destinationActivityId;
	}
	
	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public String getAccessUnitFullName() {
		return accessUnitFullName;
	}

	public void setAccessUnitFullName(String accessUnitFullName) {
		this.accessUnitFullName = accessUnitFullName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getOpinionName() {
		return opinionName;
	}

	public void setOpinionName(String opinionName) {
		this.opinionName = opinionName;
	}

	public boolean isZhfb() {
		return isZhfb;
	}

	public void setZhfb(boolean isZhfb) {
		this.isZhfb = isZhfb;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getUserAccessUnitCode() {
		return userAccessUnitCode;
	}

	public void setUserAccessUnitCode(String userAccessUnitCode) {
		this.userAccessUnitCode = userAccessUnitCode;
	}

	

}
