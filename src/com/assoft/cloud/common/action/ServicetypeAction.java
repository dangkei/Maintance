package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaServicetype;
import com.soft.web.action.base.ConResponseListInfo;

public interface ServicetypeAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaServicetype>> listServicetypes(ConditionDomainSchema<AschemaServicetype> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaServicetype> listServicetypes(AschemaServicetype condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaServicetype loadServicetype(AschemaServicetype condition,AsopQueryRequestParam param);
	public int loadNum(AschemaServicetype condition,AsopQueryRequestParam param);
	public String removeServicetypes(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaServicetype>> listServicetypes(ConditionDomainSchema<AschemaServicetype> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeServicetypes(List<String> idList);
	
	public ActionResultInfo<AschemaServicetype> loadServicetype(String id);
	
	public ActionResultInfo<AschemaServicetype> saveNewServicetype(AschemaServicetype entity);
	
	public ActionResultInfo<AschemaServicetype> saveNewServicetype(AschemaServicetype entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateServicetype(AschemaServicetype entity);
	public ActionResultInfo<String> updateServicetype(AschemaServicetype entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
