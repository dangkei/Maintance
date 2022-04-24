package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaUser;
import com.soft.web.action.base.ConResponseListInfo;

public interface UserAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaUser>> listUsers(ConditionDomainSchema<AschemaUser> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaUser> listUsers(AschemaUser condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaUser loadUser(AschemaUser condition,AsopQueryRequestParam param);
	public int loadNum(AschemaUser condition,AsopQueryRequestParam param);
	public String removeUsers(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaUser>> listUsers(ConditionDomainSchema<AschemaUser> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeUsers(List<String> idList);
	
	public ActionResultInfo<AschemaUser> loadUser(String id);
	
	public ActionResultInfo<AschemaUser> saveNewUser(AschemaUser entity);
	
	public ActionResultInfo<AschemaUser> saveNewUser(AschemaUser entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateUser(AschemaUser entity);
	public ActionResultInfo<String> updateUser(AschemaUser entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
