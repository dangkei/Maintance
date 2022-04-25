package com.assoft.cloud.common.actionextend;

import com.assoft.cloud.common.form.GroupForm;
import com.assoft.cloud.common.form.ServiceForm;
import com.assoft.cloud.common.schema.AschemaGroup;
import com.assoft.cloud.common.schema.AschemaService;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface GroupExtendAction {

	public ConResponseListInfo<ServiceForm> listServiceForms(String groupId,ConditionDomainSchema<AschemaService> condition,PageInfo pageInfo);

	public ConResponseListInfo<GroupForm> listGroupForms(AschemaGroup group,PageInfo pageInfo,AsopQueryRequestParam param);

	
	/**
	 * 用户管理的用户组，分级授权时使用
	 * @param typeId
	 * @param loginName
	 * @param condition
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<GroupForm> listUserAdminedGroupForms(String typeId,String loginName,AschemaGroup condition,PageInfo pageInfo);
}
