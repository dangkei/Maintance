package com.assoft.cloud.common.actionextend;

import com.assoft.domain.db.po.Channel;

public interface GroupTypeExtendAction {

	/**
	 * 用户组根
	 * @return
	 */
	public Channel loadRootGroupType();
}
