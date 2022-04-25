package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaService;
import com.soft.web.action.base.ConResponseListInfo;

public interface ServiceAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaService>> listServices(ConditionDomainSchema<AschemaService> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaService> listServices(AschemaService condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaService loadService(AschemaService condition,AsopQueryRequestParam param);
	public int loadNum(AschemaService condition,AsopQueryRequestParam param);
	public String removeServices(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaService>> listServices(ConditionDomainSchema<AschemaService> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeServices(List<String> idList);
	
	public ActionResultInfo<AschemaService> loadService(String id);
	
	public ActionResultInfo<AschemaService> saveNewService(AschemaService entity);
	
	public ActionResultInfo<AschemaService> saveNewService(AschemaService entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateService(AschemaService entity);
	public ActionResultInfo<String> updateService(AschemaService entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
