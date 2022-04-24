package com.assoft.cloud.common.schema;

import java.util.List;
import java.util.Map;

import com.assoft.giss.common.schema.AsopSchemaDomain;
import com.assoft.giss.common.value.AssoftFileObj;
//同步记录
public class AschemaSyncRecord extends AsopSchemaDomain{
  private static final long serialVersionUID = 1L;
  
      private String operator;//操作人员
      private String operatorName;//操作人员名称
      private String actionType;//操作类型
      private String actionTypeName;//操作类型名称
      private String objectType;//对象类型
      private String objectTypeName;//对象类型名称
      private String objectId;//对象ID
      private String objectName;//对象名称
      private String objectDetail;//对象详情
      private String app;//所属应用
      private String appName;//所属应用名称
      private String result;//同步结果
      private String resultName;//同步结果名称
      private String errorMsg;//错误信息
   
      public String getOperator(){
    	return operator;
      }
      public void setOperator(String operator){
    	this.operator=operator;
	   }
      public String getOperatorName(){
    	return operatorName;
      }
      public void setOperatorName(String operatorName){
    	this.operatorName=operatorName;
	   }
      public String getActionType(){
    	return actionType;
      }
      public void setActionType(String actionType){
    	this.actionType=actionType;
	   }
      public String getActionTypeName(){
    	return actionTypeName;
      }
      public void setActionTypeName(String actionTypeName){
    	this.actionTypeName=actionTypeName;
	   }
      public String getObjectType(){
    	return objectType;
      }
      public void setObjectType(String objectType){
    	this.objectType=objectType;
	   }
      public String getObjectTypeName(){
    	return objectTypeName;
      }
      public void setObjectTypeName(String objectTypeName){
    	this.objectTypeName=objectTypeName;
	   }
      public String getObjectId(){
    	return objectId;
      }
      public void setObjectId(String objectId){
    	this.objectId=objectId;
	   }
      public String getObjectName(){
    	return objectName;
      }
      public void setObjectName(String objectName){
    	this.objectName=objectName;
	   }
      public String getObjectDetail(){
    	return objectDetail;
      }
      public void setObjectDetail(String objectDetail){
    	this.objectDetail=objectDetail;
	   }
      public String getApp(){
    	return app;
      }
      public void setApp(String app){
    	this.app=app;
	   }
      public String getAppName(){
    	return appName;
      }
      public void setAppName(String appName){
    	this.appName=appName;
	   }
      public String getResult(){
    	return result;
      }
      public void setResult(String result){
    	this.result=result;
	   }
      public String getResultName(){
    	return resultName;
      }
      public void setResultName(String resultName){
    	this.resultName=resultName;
	   }
      public String getErrorMsg(){
    	return errorMsg;
      }
      public void setErrorMsg(String errorMsg){
    	this.errorMsg=errorMsg;
	   }
  
  @Override
  public String schemaName() {

		return "syncRecord";
	}
	 @Override
  public  String schemaType() {

		return "0";
	}
	@Override
	public void fitElements2Map(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}
}
