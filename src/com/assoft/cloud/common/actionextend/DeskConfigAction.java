package com.assoft.cloud.common.actionextend;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloud.common.value.UserDesk;

public interface DeskConfigAction {

	/**
	 * 移除某条目
	 * @param desk
	 * @param type
	 * @param name
	 */
	public void removeItem(UserDesk desk,String type,String name);
	
	/**
	 * 设置皮肤
	 * @param desk
	 * @param skin
	 * @param skinType
	 * @return
	 */
	public String setSkin(UserDesk desk,String skin,String skinType);
	
	
	/**
	 * 向用户桌面中添加条目
	 * @param sids 服务id列表
	 * @param desk
	 */
	public void addServiceItems2Desk(List<String> sids,UserDesk desk);
	
	
	public ActionResultInfo<String> addGroup2Desk(String groupName,UserDesk desk);
	
	public ActionResultInfo<String> modifyGroupName(String oldName,String newName,UserDesk desk);
	
	public ActionResultInfo<String> removeGroup(String groupName,UserDesk desk);
	
	public ActionResultInfo<String> addServiceItem2Group(String serviceId,String groupName,UserDesk desk);
	
	public ActionResultInfo<String> removeServiceFromGroup(String serviceId,String groupName,UserDesk desk);
	
	public Map<String, Integer> buildGroupTodoNumMap(UserDesk desk,String loginName, List<String> groupNames);
	
	
}
