package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaUserdesk;
import com.soft.web.action.base.ConResponseListInfo;

public interface UserdeskAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaUserdesk>> listUserdesks(ConditionDomainSchema<AschemaUserdesk> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaUserdesk> listUserdesks(AschemaUserdesk condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaUserdesk loadUserdesk(AschemaUserdesk condition,AsopQueryRequestParam param);
	public int loadNum(AschemaUserdesk condition,AsopQueryRequestParam param);
	public String removeUserdesks(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaUserdesk>> listUserdesks(ConditionDomainSchema<AschemaUserdesk> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeUserdesks(List<String> idList);
	
	public ActionResultInfo<AschemaUserdesk> loadUserdesk(String id);
	
	public ActionResultInfo<AschemaUserdesk> saveNewUserdesk(AschemaUserdesk entity);
	
	public ActionResultInfo<AschemaUserdesk> saveNewUserdesk(AschemaUserdesk entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateUserdesk(AschemaUserdesk entity);
	public ActionResultInfo<String> updateUserdesk(AschemaUserdesk entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
