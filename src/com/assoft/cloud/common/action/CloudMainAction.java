package com.assoft.cloud.common.action;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.config.LocalConfig;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloudclient.common.AsopUser;

public interface CloudMainAction {

	/**
	 * 登录
	 * @param String loginName,loginPassword sessionToken
	 * @return
	 */
	public ActionResultInfo<UserProperty> loadLoginPersonByLoginName(String loginName,String loginPassword);
	
	/**
	 * 单点登录方法重载
	 */
	public ActionResultInfo<UserProperty> loadLoginPersonByLoginName(String loginName);
	
	public ActionResultInfo<String> bindUserWopenId(String userProductId,String wopenId);
	
	
	/**
	 * 根据微信标识获取用户
	 * @param wopenId
	 * @return
	 */
	public ActionResultInfo<UserProperty> loadLoginPersonWopenId(String wopenId);
	
	


	
	//public ActionResultInfo<AsopUser> login2Admin(String key);
	
	public ActionResultInfo<AsopUser> autologinByLoginName(String loginName);
	
	

	

	

	
	public ActionResultInfo<LocalConfig> loadConfig();
	
	public void saveConfig(LocalConfig localConfig) throws Exception;
}
