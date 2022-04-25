package com.assoft.cloud.common.actionextend;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloud.common.form.AppExchangeInfo;
import com.assoft.cloud.common.form.AppForm;
import com.assoft.cloud.common.schema.AschemaApp;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface AppExtendAction {

	public ConResponseListInfo<AppForm> listApps(ConditionDomainSchema<AschemaApp> condition,PageInfo pageInfo);
	
	public ConResponseListInfo<AppForm> listAppRoleAdminApps(String loginName,ConditionDomainSchema<AschemaApp> condition,PageInfo pageInfo);
	public ConResponseListInfo<AppForm> listAppServiceAdminApps(String loginName,ConditionDomainSchema<AschemaApp> condition,PageInfo pageInfo);
	public AppForm loadAppForm(String appId);
	
	public AppExchangeInfo buildAppExchangeInfo(String id);	
	public ActionResultInfo<String> removeApp(String id);
	public ActionResultInfo<String> importApp(AppExchangeInfo appExchangeInfo);
	
	public boolean needSyncBaseInfo();
	
	public boolean syncBaseInfo();
}
