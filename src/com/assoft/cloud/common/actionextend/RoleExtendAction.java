package com.assoft.cloud.common.actionextend;


import java.util.List;

import com.assoft.cloud.common.form.RoleForm;
import com.assoft.cloud.common.form.RoleFullInfo;
import com.assoft.cloud.common.schema.AschemaAppType;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaGroup;
import com.assoft.cloud.common.schema.AschemaPermission;
import com.assoft.cloud.common.schema.AschemaRole;
import com.assoft.cloud.common.value.RoleCreateInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.soft.web.action.base.ConResponseListInfo;

public interface RoleExtendAction {

	/**
	 * 某角色下的用户数量
	 * @param roleId
	 * @return
	 */
	public int loadRoleUserNum(String roleId);
	
	
	/**
	 * 某角色下的子角色数量
	 * @param fatherRoleId
	 * @return
	 */
	public int loadSonRoleNum(String fatherRoleId);
	
	
	public RoleForm loadRoleForm(String roleId,String loginName);
	
	
	/**
	 * 角色还能添加的权限列表
	 * @param roleId
	 * @return
	 */
	public RoleCreateInfo loadRoleCreateInfo(String roleId);
	
	
	public RoleFullInfo loadRoleFullInfo(String roleId);
	
	/**
	 * 根据条件查询form表单
	 * @param title
	 * @param fatherId
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<RoleForm> listRoleForms(String title,String fatherId,String cLoginName,PageInfo pageInfo);

	
	public ConResponseListInfo<RoleForm> listAdminedRoleForms(String title,String cLoginName,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaDept> listOpDeptsByFather(String fatherRoleId,String title,PageInfo pageInfo);
	
	
}
