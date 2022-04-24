package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaDept;
import com.soft.web.action.base.ConResponseListInfo;

public interface DeptAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaDept>> listDepts(ConditionDomainSchema<AschemaDept> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaDept> listDepts(AschemaDept condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaDept loadDept(AschemaDept condition,AsopQueryRequestParam param);
	public int loadNum(AschemaDept condition,AsopQueryRequestParam param);
	public String removeDepts(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDept>> listDepts(ConditionDomainSchema<AschemaDept> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeDepts(List<String> idList);
	
	public ActionResultInfo<AschemaDept> loadDept(String id);
	
	public ActionResultInfo<AschemaDept> saveNewDept(AschemaDept entity);
	
	public ActionResultInfo<AschemaDept> saveNewDept(AschemaDept entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateDept(AschemaDept entity);
	public ActionResultInfo<String> updateDept(AschemaDept entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
