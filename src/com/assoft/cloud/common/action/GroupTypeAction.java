package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaGroupType;
import com.soft.web.action.base.ConResponseListInfo;

public interface GroupTypeAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaGroupType>> listGroupTypes(ConditionDomainSchema<AschemaGroupType> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaGroupType> listGroupTypes(AschemaGroupType condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaGroupType loadGroupType(AschemaGroupType condition,AsopQueryRequestParam param);
	public int loadNum(AschemaGroupType condition,AsopQueryRequestParam param);
	public String removeGroupTypes(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaGroupType>> listGroupTypes(ConditionDomainSchema<AschemaGroupType> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeGroupTypes(List<String> idList);
	
	public ActionResultInfo<AschemaGroupType> loadGroupType(String id);
	
	public ActionResultInfo<AschemaGroupType> saveNewGroupType(AschemaGroupType entity);
	
	public ActionResultInfo<AschemaGroupType> saveNewGroupType(AschemaGroupType entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateGroupType(AschemaGroupType entity);
	public ActionResultInfo<String> updateGroupType(AschemaGroupType entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
