package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaConfigData;
import com.soft.web.action.base.ConResponseListInfo;

public interface ConfigDataAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaConfigData>> listConfigDatas(ConditionDomainSchema<AschemaConfigData> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaConfigData> listConfigDatas(AschemaConfigData condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaConfigData loadConfigData(AschemaConfigData condition,AsopQueryRequestParam param);
	public int loadNum(AschemaConfigData condition,AsopQueryRequestParam param);
	public String removeConfigDatas(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaConfigData>> listConfigDatas(ConditionDomainSchema<AschemaConfigData> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeConfigDatas(List<String> idList);
	
	public ActionResultInfo<AschemaConfigData> loadConfigData(String id);
	
	public ActionResultInfo<AschemaConfigData> saveNewConfigData(AschemaConfigData entity);
	
	public ActionResultInfo<AschemaConfigData> saveNewConfigData(AschemaConfigData entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateConfigData(AschemaConfigData entity);
	public ActionResultInfo<String> updateConfigData(AschemaConfigData entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
