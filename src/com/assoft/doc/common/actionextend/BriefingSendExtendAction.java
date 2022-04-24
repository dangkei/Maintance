package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.BriefingReceiveForm;
import com.assoft.doc.common.schema.AschemaBriefingReceive;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

public interface BriefingSendExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingSend>> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition,PageInfo pageInfo);
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingSend>> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition,PageInfo pageInfo,UserProperty userProperty);
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(AschemaBriefingSend condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaBriefingSend loadBriefingSend(AschemaBriefingSend condition,AsopQueryRequestParam param);
	public int loadNum(AschemaBriefingSend condition,AsopQueryRequestParam param);
	public String removeBriefingSends(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingSend>> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeBriefingSends(List<String> idList);
	
	public ActionResultInfo<AschemaBriefingSend> loadBriefingSend(String id);
	
	public ActionResultInfo<AschemaBriefingSend> saveNewBriefingSend(AschemaBriefingSend entity);
	
	public ActionResultInfo<AschemaBriefingSend> saveNewBriefingSend(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateBriefingSend(AschemaBriefingSend entity);
	public ActionResultInfo<String> updateBriefingSend(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<AschemaBriefingSend> update(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<AschemaBriefingSend> saveNewBriefingSend(AschemaBriefingSend entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser userInfo, String activityId, AssoftFlowRecord flowRecord);
	public ActionResultInfo<String> updateBriefingSend(AschemaBriefingSend entity,
			Map<String, List<AssoftFileObj>> emap, UserProperty userProperty, String activityInstanceId,
			AschemaBriefingReceive docReceive, AssoftFlowRecord flowRecord);
	public BriefingReceiveForm loadBriefingForm(String id);
	public ActionResultInfo<String> withdraw(String id, AsopUser user);
	public ConResponseListInfo<BriefingReceiveForm> listBriefingSends(
			ConditionDomainSchema<AschemaBriefingSend> conditionDomainSchema, PageInfo pageInfo, AsopUser userInfo);
	ActionResultInfo<AschemaBriefingSend> draftSend(AschemaBriefingSend entity,
			Map<String, List<AssoftFileObj>> eleFileMap, AsopUser user,
			String activityId, AssoftFlowRecord flowRecord);
	ActionResultInfo<ConResponseListInfo<AschemaBriefingSend>> listDraft(
			ConditionDomainSchema<AschemaBriefingSend> condition,
			PageInfo pageInfo, UserProperty userProperty);
	ConResponseListInfo<BriefingReceiveForm> listBriefingSends(
			ConditionDomainSchema<AschemaBriefingSend> condition,
			PageInfo pageInfo, AsopUser userInfo, String type);
	ActionResultInfo<String> updateSend(String sendId, String status);
}
