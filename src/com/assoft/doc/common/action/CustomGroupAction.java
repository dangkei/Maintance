package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaCustomGroup;
import com.soft.web.action.base.ConResponseListInfo;

public interface CustomGroupAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaCustomGroup>> listCustomGroups(ConditionDomainSchema<AschemaCustomGroup> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaCustomGroup> listCustomGroups(AschemaCustomGroup condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaCustomGroup loadCustomGroup(AschemaCustomGroup condition,AsopQueryRequestParam param);
	public int loadNum(AschemaCustomGroup condition,AsopQueryRequestParam param);
	public String removeCustomGroups(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaCustomGroup>> listCustomGroups(ConditionDomainSchema<AschemaCustomGroup> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeCustomGroups(List<String> idList);
	
	public ActionResultInfo<AschemaCustomGroup> loadCustomGroup(String id);
	
	public ActionResultInfo<AschemaCustomGroup> saveNewCustomGroup(AschemaCustomGroup entity);
	
	public ActionResultInfo<AschemaCustomGroup> saveNewCustomGroup(AschemaCustomGroup entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateCustomGroup(AschemaCustomGroup entity);
	public ActionResultInfo<String> updateCustomGroup(AschemaCustomGroup entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
