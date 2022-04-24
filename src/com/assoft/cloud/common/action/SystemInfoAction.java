package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaSystemInfo;
import com.soft.web.action.base.ConResponseListInfo;

public interface SystemInfoAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaSystemInfo>> listSystemInfos(ConditionDomainSchema<AschemaSystemInfo> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaSystemInfo> listSystemInfos(AschemaSystemInfo condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaSystemInfo loadSystemInfo(AschemaSystemInfo condition,AsopQueryRequestParam param);
	public int loadNum(AschemaSystemInfo condition,AsopQueryRequestParam param);
	public String removeSystemInfos(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaSystemInfo>> listSystemInfos(ConditionDomainSchema<AschemaSystemInfo> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeSystemInfos(List<String> idList);
	
	public ActionResultInfo<AschemaSystemInfo> loadSystemInfo(String id);
	
	public ActionResultInfo<AschemaSystemInfo> saveNewSystemInfo(AschemaSystemInfo entity);
	
	public ActionResultInfo<AschemaSystemInfo> saveNewSystemInfo(AschemaSystemInfo entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateSystemInfo(AschemaSystemInfo entity);
	public ActionResultInfo<String> updateSystemInfo(AschemaSystemInfo entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
