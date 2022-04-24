package com.assoft.cloud.common.actionextend;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.schema.AschemaResourceUrl;

public interface ResourceUrlExtendAction {

	public ActionResultInfo<String> createResource(UserProperty up,AschemaResourceUrl url);
	
	/**
	 * 检测资源
	 * @param id
	 * @return
	 */
	public ActionResultInfo<String> detectResource(String id);
	
	
	public String go2Resource(String urlId,String loginName);
}
