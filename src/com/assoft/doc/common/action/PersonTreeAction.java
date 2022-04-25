package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaPersonTree;
import com.soft.web.action.base.ConResponseListInfo;

public interface PersonTreeAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaPersonTree>> listPersonTrees(ConditionDomainSchema<AschemaPersonTree> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaPersonTree> listPersonTrees(AschemaPersonTree condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaPersonTree loadPersonTree(AschemaPersonTree condition,AsopQueryRequestParam param);
	public int loadNum(AschemaPersonTree condition,AsopQueryRequestParam param);
	public String removePersonTrees(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaPersonTree>> listPersonTrees(ConditionDomainSchema<AschemaPersonTree> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removePersonTrees(List<String> idList);
	
	public ActionResultInfo<AschemaPersonTree> loadPersonTree(String id);
	
	public ActionResultInfo<AschemaPersonTree> saveNewPersonTree(AschemaPersonTree entity);
	
	public ActionResultInfo<AschemaPersonTree> saveNewPersonTree(AschemaPersonTree entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updatePersonTree(AschemaPersonTree entity);
	public ActionResultInfo<String> updatePersonTree(AschemaPersonTree entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
