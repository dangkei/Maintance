package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaAuthScope;
import com.soft.web.action.base.ConResponseListInfo;

public interface AuthScopeAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaAuthScope>> listAuthScopes(ConditionDomainSchema<AschemaAuthScope> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaAuthScope> listAuthScopes(AschemaAuthScope condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaAuthScope loadAuthScope(AschemaAuthScope condition,AsopQueryRequestParam param);
	public int loadNum(AschemaAuthScope condition,AsopQueryRequestParam param);
	public String removeAuthScopes(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaAuthScope>> listAuthScopes(ConditionDomainSchema<AschemaAuthScope> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeAuthScopes(List<String> idList);
	
	public ActionResultInfo<AschemaAuthScope> loadAuthScope(String id);
	
	public ActionResultInfo<AschemaAuthScope> saveNewAuthScope(AschemaAuthScope entity);
	
	public ActionResultInfo<AschemaAuthScope> saveNewAuthScope(AschemaAuthScope entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateAuthScope(AschemaAuthScope entity);
	public ActionResultInfo<String> updateAuthScope(AschemaAuthScope entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
