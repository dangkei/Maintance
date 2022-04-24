package com.assoft.aspweb.common.action;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.config.LocalConfig;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.record.common.value.AssoftActionRecord;

public interface AdminMainAction {


	
	public ActionResultInfo<UserProperty> personLoginByLoginName(String loginName,String loginPassword,String accessType,AssoftActionRecord record);
	
	
	/**
	 * 单点登录方法重载
	 */
	public ActionResultInfo<UserProperty> autoLoadLoginPersonByLoginName(String loginName,String accessType);
	
	public ActionResultInfo<String> bindUserWopenId(String userProductId,String wopenId);
	
	/**
	 * 修改密码
	 * @param String personId,oldPassword,newPassword
	 * @return
	 */
	public ActionResultInfo<AsopUser> updateUserPassword(String personId, String oldPassword, String newPassword,AssoftActionRecord record);
	

	
	/**
	 * 根据微信标识获取用户
	 * @param wopenId
	 * @return
	 */
	public ActionResultInfo<UserProperty> loadLoginPersonWopenId(String wopenId);
	
	


	
	//public ActionResultInfo<AsopUser> login2Admin(String key);
	
	public ActionResultInfo<AsopUser> autologinByLoginName(String loginName);
	
	

	

	//登录后转向的地址
	public String loadMainurlAftLogin();
	

	
	public ActionResultInfo<LocalConfig> loadConfig();
	
	public void saveConfig(LocalConfig localConfig) throws Exception;
}
