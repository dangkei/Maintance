package com.assoft.cloud.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.form.OrgForm;
import com.assoft.cloud.common.form.UserForm;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.domain.db.po.Channel;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.entity.AsopCata;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface OrgAction {

	public OrgForm loadOrgForm(String deptDn,String loginName);
	
	/**
	 * 加载部门根
	 * @return
	 */
	public Channel loadDeptRoot();
	
	public Channel loadRoleRoot();
	
	public Channel loadGroupRoot();
	
	/**
	 * 部门路径
	 * 比如部门总根，软件开发部
	 * @param id
	 * @return
	 */
	public List<AsopCata> listPathDepts(String id);
	
	/**
	 * 按条件查询用户组
	 * @param title
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<AsopCata> listGroups(String title,PageInfo pageInfo);
	
	/**
	 * 按条件查询角色
	 * @param title
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<AsopCata> listRoles(String title,PageInfo pageInfo);
	
	
	public ConResponseListInfo<AschemaUser> listGroupUsers(PageInfo pageInfo,String groupDn,String title);
	
	public ConResponseListInfo<AschemaUser> listRoleUsers(PageInfo pageInfo,String roleId,String title);
	
	/**
	 * 列出待添加到用户组中的用户
	 * @param groupId
	 * @param loginName 当前用户
	 * @param conditionDomainSchema
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<AschemaUser> listToAdd2GroupUsers(String groupId,String loginName,ConditionDomainSchema<AschemaUser> conditionDomainSchema,PageInfo pageInfo);

	public ConResponseListInfo<AschemaUser> listToAdd2RoleUsers(String groupId,ConditionDomainSchema<AschemaUser> conditionDomainSchema,PageInfo pageInfo);
	


	/**
	 * 向角色中家人
	 * @param userIdList
	 * @param roleDn
	 * @return
	 */
	public ActionResultInfo<String> addUsers2Role(List<String> userIdList,final	String roleId);
	
	public ActionResultInfo<String> removeUserFromRole(List<String> userIdList, final String roleId);
	

	
	

	
	public ActionResultInfo<ConResponseListInfo<UserForm>> listUserForms(ConditionDomainSchema<AschemaUser> condition,AsopQueryRequestParam param,PageInfo pageInfo);
	
	/**
	 * 初始化组织机构等根类目信息
	 * @return
	 */
	public void initClassRoots();
	
	/**
	 * 是否需要初始化
	 * @return
	 */
	public boolean needInitClassRoots();

	/**
	 * 用户同步
	 * @param up
	 * @param result
	 * @param actionType
	 */
	public void syncUser(UserProperty up, AsopCata result, String actionType);
	
}
