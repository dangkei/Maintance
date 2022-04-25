package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaAppType;
import com.soft.web.action.base.ConResponseListInfo;

public interface AppTypeAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaAppType>> listAppTypes(ConditionDomainSchema<AschemaAppType> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaAppType> listAppTypes(AschemaAppType condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaAppType loadAppType(AschemaAppType condition,AsopQueryRequestParam param);
	public int loadNum(AschemaAppType condition,AsopQueryRequestParam param);
	public String removeAppTypes(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaAppType>> listAppTypes(ConditionDomainSchema<AschemaAppType> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeAppTypes(List<String> idList);
	
	public ActionResultInfo<AschemaAppType> loadAppType(String id);
	
	public ActionResultInfo<AschemaAppType> saveNewAppType(AschemaAppType entity);
	
	public ActionResultInfo<AschemaAppType> saveNewAppType(AschemaAppType entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateAppType(AschemaAppType entity);
	public ActionResultInfo<String> updateAppType(AschemaAppType entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
