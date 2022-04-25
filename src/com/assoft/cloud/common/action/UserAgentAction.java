package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaUserAgent;
import com.soft.web.action.base.ConResponseListInfo;

public interface UserAgentAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaUserAgent>> listUserAgents(ConditionDomainSchema<AschemaUserAgent> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaUserAgent> listUserAgents(AschemaUserAgent condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaUserAgent loadUserAgent(AschemaUserAgent condition,AsopQueryRequestParam param);
	public int loadNum(AschemaUserAgent condition,AsopQueryRequestParam param);
	public String removeUserAgents(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaUserAgent>> listUserAgents(ConditionDomainSchema<AschemaUserAgent> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeUserAgents(List<String> idList);
	
	public ActionResultInfo<AschemaUserAgent> loadUserAgent(String id);
	
	public ActionResultInfo<AschemaUserAgent> saveNewUserAgent(AschemaUserAgent entity);
	
	public ActionResultInfo<AschemaUserAgent> saveNewUserAgent(AschemaUserAgent entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateUserAgent(AschemaUserAgent entity);
	public ActionResultInfo<String> updateUserAgent(AschemaUserAgent entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
