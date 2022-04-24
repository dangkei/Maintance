package com.assoft.cloud.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.form.ApproleForm;
import com.assoft.cloud.common.form.ApproleFullInfo;
import com.assoft.cloud.common.schema.AschemaApprole;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaGroup;
import com.assoft.cloud.common.schema.AschemaService;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface ApproleExtendAction {

	public ActionResultInfo<AschemaApprole> createNewrole(UserProperty up,AschemaApprole approle);
	
	/**
	 * 更新
	 * @param up
	 * @param roleId
	 * @param approle
	 * @return
	 */
	public ActionResultInfo<String> updateRole(UserProperty up,String roleId,AschemaApprole approle);
	
	
	public ConResponseListInfo<ApproleForm> listApproleForms(ConditionDomainSchema<AschemaApprole> condition,PageInfo pageInfo,AsopQueryRequestParam param);

	public ActionResultInfo<String> removeApproles(List<String> idList);
	
	public ApproleForm loadApproleForm(String roleId);
	
	public ApproleFullInfo loadApproleFullInfo(String roleId);
	
	
	public ConResponseListInfo<AschemaDept> listOpdeptsByAppId(String appId,String title,PageInfo pageInfo);
	public List<AschemaDept> listOpdeptsByRoleId(String roleId);
	
	public ConResponseListInfo<AschemaDept> listOpdeptsByFather(String roleId,String title,PageInfo pageInfo);
	
	public List<AschemaGroup> listOpgroupsByRoleId(String roleId);
	
	public ConResponseListInfo<AschemaGroup> listOpgroupsByFather(String roleId,String title,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaGroup> listOpgroupsByAppId(String appId,String title,PageInfo pageInfo);
	
	public List<AschemaUser> listUsersByRoleId(String roleId);
	
	/**
	 * 父角色约束人员添加范围
	 * @param roleId
	 * @param title
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<AschemaUser> listUsersByFather(String roleId,String title,PageInfo pageInfo);
	
	
	/**
	 * 根据应用约束人员添加范围
	 * @param appId
	 * @param title
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<AschemaUser> listUsersByApp(String appId,String title,PageInfo pageInfo);
	
	
	public List<AschemaService> listroleServiceByRoleId(String roleId);
	
	
}
