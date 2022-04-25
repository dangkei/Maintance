package com.assoft.cloud.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloud.common.schema.AschemaAuthScope;

public interface AuthscopeExtendAction {

	public AschemaAuthScope loadAuthScopeByTypeRole(String serviceId,String scopeType,String role);
	
	
	public AschemaAuthScope loadAuthScopeByRole(String role);
	
	/**
	 * 将授权同步到服务列表
	 * @param scopeId
	 * @param serviceList
	 * @return
	 */
	public ActionResultInfo<String> sync2ServiceList(List<String> scopeIds,List<String> serviceList);
	
	
	/**
	 * 清空某服务的授权
	 * @param serviceId
	 * @return
	 */
	public ActionResultInfo<String> clearAuthscopes(String serviceId);
	
	//重新计算某角色涉及到的服务授权范围
		public void reBuildRoleServiceScope(List<String> oldServiceList,String newScopeId);
		
		public void reBuildServiceByUserScope(String scopeId);
	
}
