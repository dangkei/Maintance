package com.assoft.cloud.common.actionextend;

import com.assoft.cloud.common.form.PermissionForm;
import com.assoft.cloud.common.schema.AschemaAppType;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaGroup;
import com.assoft.cloud.common.schema.AschemaPermission;
import com.assoft.cloud.common.schema.AschemaRole;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.soft.web.action.base.ConResponseListInfo;

/**
 * 权限扩展类
 * @author wzj
 *
 */
public interface PermissionExtendAction {

	
	
	/**
	 * 加载权限表单
	 * @param id
	 * @return
	 */
	public PermissionForm loadPermissionForm(String id);
	
	
	public ConResponseListInfo<PermissionForm> listForms(AschemaPermission permission,PageInfo pageInfo,AsopQueryRequestParam param);

    //一个角色不可能同时拥有部门管理权限和
	public ConResponseListInfo<AschemaDept> listOpDeptsByFather(String roleId,String title,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaGroup> listOpGroupsByFather(String roleId,String title,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaRole> listOpRolesByFather(String roleId,String title,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaAppType> listOpApprolesByFather(String roleId,String title,PageInfo pageInfo);
	
	
	public ConResponseListInfo<AschemaAppType> listOpAppservicesByFather(String roleId,String title,PageInfo pageInfo);

	public ConResponseListInfo<AschemaDept> listOpLogDeptsByFather(String roleId,String title,PageInfo pageInfo);
	
	
}
