package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaDoneDoc;
import com.soft.web.action.base.ConResponseListInfo;

public interface DoneDocExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaDoneDoc>> listDoneDocs(ConditionDomainSchema<AschemaDoneDoc> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaDoneDoc> listDoneDocs(AschemaDoneDoc condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaDoneDoc loadDoneDoc(AschemaDoneDoc condition,AsopQueryRequestParam param);
	public int loadNum(AschemaDoneDoc condition,AsopQueryRequestParam param);
	public String removeDoneDocs(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDoneDoc>> listDoneDocs(ConditionDomainSchema<AschemaDoneDoc> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeDoneDocs(List<String> idList);
	
	public ActionResultInfo<AschemaDoneDoc> loadDoneDoc(String id);
	
	public ActionResultInfo<AschemaDoneDoc> saveNewDoneDoc(AschemaDoneDoc entity);
	
	public ActionResultInfo<AschemaDoneDoc> saveNewDoneDoc(AschemaDoneDoc entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateDoneDoc(AschemaDoneDoc entity);
	public ActionResultInfo<String> updateDoneDoc(AschemaDoneDoc entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<ConResponseListInfo<AschemaDoneDoc>> listDoneDocs(
			ConditionDomainSchema<AschemaDoneDoc> conditionDomainSchema, PageInfo pageInfo, AsopUser user);
	ActionResultInfo<ConResponseListInfo<AschemaDoneDoc>> listDoneDocsByLeader(
			ConditionDomainSchema<AschemaDoneDoc> condition, PageInfo pageInfo,
			AsopUser user, String loginNames);
}
