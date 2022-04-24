package com.assoft.doc.common.actionextend;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;

  
public interface ServiceExtendAction {
	
	public ActionResultInfo<String> go2Service(UserProperty userProperty, String sId, String mobile);
}
