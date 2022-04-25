package com.assoft.cloud.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.form.ServiceForm;
import com.assoft.cloud.common.schema.AschemaService;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.entity.AsopCata;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface UserExtendAction {

	public ConResponseListInfo<ServiceForm> listServiceForms(String loginName,ConditionDomainSchema<AschemaService> condition,PageInfo pageInfo);

	public ActionResultInfo<String> removeUsers(List<String> list);
	
	public AschemaUser loadUserByLoginName(String loginName);

	public void syncUser(UserProperty up, AsopCata asopCata, String actionType);

	public void syncUser(UserProperty up, List<AschemaUser> userList, String actionType);


	/**
	 *        重置某用户的密码
	 * @param userId
	 */
	public ActionResultInfo<String> restUserPassById(String userId);
	
	
	public void userRegister(List<AschemaUser> userList);

	public void updateUserList(List<AschemaUser> userList);

	
	public ConResponseListInfo<AschemaUser> listNoDeptUsers(String title,String deptDn,PageInfo pageInfo);
	
	public ActionResultInfo<String> addUser2Dept(List<String> userLoginNames,String deptDn);
	
	/**
	 * 禁用用户
	 * @param userIds
	 * @return
	 */
	public ActionResultInfo<String> forbidUsers(List<String> userIds);
	
	public ActionResultInfo<String> removeForbid(List<String> userIds);

	public void sendPassSms(String loginName,String phone,String pass);
}
