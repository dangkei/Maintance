package com.assoft.cloud.common.actionextend;

import com.assoft.cloud.common.schema.AschemaAppType;
import com.assoft.domain.db.po.Channel;
import com.assoft.file.asopdb.po.PageInfo;
import com.soft.web.action.base.ConResponseListInfo;

public interface AppTypeExtendAction {

	/**
	 * 应用类别根
	 * @return
	 */
	public Channel loadRootAppType();
	
	public ConResponseListInfo<AschemaAppType> listAppRoleAdminTypes(String title,String loginName,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaAppType> listAppServiceAdminTypes(String title,String loginName,PageInfo pageInfo);
}
