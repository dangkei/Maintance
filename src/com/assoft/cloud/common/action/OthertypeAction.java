package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaOthertype;
import com.soft.web.action.base.ConResponseListInfo;

public interface OthertypeAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaOthertype>> listOthertypes(ConditionDomainSchema<AschemaOthertype> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaOthertype> listOthertypes(AschemaOthertype condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaOthertype loadOthertype(AschemaOthertype condition,AsopQueryRequestParam param);
	public int loadNum(AschemaOthertype condition,AsopQueryRequestParam param);
	public String removeOthertypes(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaOthertype>> listOthertypes(ConditionDomainSchema<AschemaOthertype> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeOthertypes(List<String> idList);
	
	public ActionResultInfo<AschemaOthertype> loadOthertype(String id);
	
	public ActionResultInfo<AschemaOthertype> saveNewOthertype(AschemaOthertype entity);
	
	public ActionResultInfo<AschemaOthertype> saveNewOthertype(AschemaOthertype entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateOthertype(AschemaOthertype entity);
	public ActionResultInfo<String> updateOthertype(AschemaOthertype entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
