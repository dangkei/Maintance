package com.assoft.czjDoc.common.action;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.czjDoc.common.schema.AschemaUserDesk;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

public interface UserDeskAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaUserDesk>> listUserDesks(ConditionDomainSchema<AschemaUserDesk> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaUserDesk> listUserDesks(AschemaUserDesk condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaUserDesk loadUserDesk(AschemaUserDesk condition,AsopQueryRequestParam param);
	public int loadNum(AschemaUserDesk condition,AsopQueryRequestParam param);
	public String removeUserDesks(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaUserDesk>> listUserDesks(ConditionDomainSchema<AschemaUserDesk> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeUserDesks(List<String> idList);
	
	public ActionResultInfo<AschemaUserDesk> loadUserDesk(String id);
	
	public ActionResultInfo<AschemaUserDesk> saveNewUserDesk(AschemaUserDesk entity);
	
	public ActionResultInfo<AschemaUserDesk> saveNewUserDesk(AschemaUserDesk entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateUserDesk(AschemaUserDesk entity);
	public ActionResultInfo<String> updateUserDesk(AschemaUserDesk entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
