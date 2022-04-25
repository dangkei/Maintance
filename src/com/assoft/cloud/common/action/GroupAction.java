package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaGroup;
import com.soft.web.action.base.ConResponseListInfo;

public interface GroupAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaGroup>> listGroups(ConditionDomainSchema<AschemaGroup> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaGroup> listGroups(AschemaGroup condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaGroup loadGroup(AschemaGroup condition,AsopQueryRequestParam param);
	public int loadNum(AschemaGroup condition,AsopQueryRequestParam param);
	public String removeGroups(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaGroup>> listGroups(ConditionDomainSchema<AschemaGroup> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeGroups(List<String> idList);
	
	public ActionResultInfo<AschemaGroup> loadGroup(String id);
	
	public ActionResultInfo<AschemaGroup> saveNewGroup(AschemaGroup entity);
	
	public ActionResultInfo<AschemaGroup> saveNewGroup(AschemaGroup entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateGroup(AschemaGroup entity);
	public ActionResultInfo<String> updateGroup(AschemaGroup entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
