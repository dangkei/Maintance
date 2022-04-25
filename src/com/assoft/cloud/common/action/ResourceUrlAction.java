package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaResourceUrl;
import com.soft.web.action.base.ConResponseListInfo;

public interface ResourceUrlAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaResourceUrl>> listResourceUrls(ConditionDomainSchema<AschemaResourceUrl> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaResourceUrl> listResourceUrls(AschemaResourceUrl condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaResourceUrl loadResourceUrl(AschemaResourceUrl condition,AsopQueryRequestParam param);
	public int loadNum(AschemaResourceUrl condition,AsopQueryRequestParam param);
	public String removeResourceUrls(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaResourceUrl>> listResourceUrls(ConditionDomainSchema<AschemaResourceUrl> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeResourceUrls(List<String> idList);
	
	public ActionResultInfo<AschemaResourceUrl> loadResourceUrl(String id);
	
	public ActionResultInfo<AschemaResourceUrl> saveNewResourceUrl(AschemaResourceUrl entity);
	
	public ActionResultInfo<AschemaResourceUrl> saveNewResourceUrl(AschemaResourceUrl entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateResourceUrl(AschemaResourceUrl entity);
	public ActionResultInfo<String> updateResourceUrl(AschemaResourceUrl entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
