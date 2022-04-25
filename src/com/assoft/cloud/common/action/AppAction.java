package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaApp;
import com.soft.web.action.base.ConResponseListInfo;

public interface AppAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaApp>> listApps(ConditionDomainSchema<AschemaApp> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaApp> listApps(AschemaApp condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaApp loadApp(AschemaApp condition,AsopQueryRequestParam param);
	public int loadNum(AschemaApp condition,AsopQueryRequestParam param);
	public String removeApps(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaApp>> listApps(ConditionDomainSchema<AschemaApp> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeApps(List<String> idList);
	
	public ActionResultInfo<AschemaApp> loadApp(String id);
	
	public ActionResultInfo<AschemaApp> saveNewApp(AschemaApp entity);
	
	public ActionResultInfo<AschemaApp> saveNewApp(AschemaApp entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateApp(AschemaApp entity);
	public ActionResultInfo<String> updateApp(AschemaApp entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
