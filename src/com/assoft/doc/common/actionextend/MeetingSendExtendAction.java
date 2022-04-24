package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.MeetingReceiveForm;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

public interface MeetingSendExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingSend>> listMeetingSends(ConditionDomainSchema<AschemaMeetingSend> condition,PageInfo pageInfo);
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingSend>> listMeetingSends(ConditionDomainSchema<AschemaMeetingSend> condition,PageInfo pageInfo,UserProperty userProperty);
	public ConResponseListInfo<AschemaMeetingSend> listMeetingSends(AschemaMeetingSend condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaMeetingSend loadMeetingSend(AschemaMeetingSend condition,AsopQueryRequestParam param);
	public int loadNum(AschemaMeetingSend condition,AsopQueryRequestParam param);
	public String removeMeetingSends(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingSend>> listMeetingSends(ConditionDomainSchema<AschemaMeetingSend> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeMeetingSends(List<String> idList);
	
	public ActionResultInfo<AschemaMeetingSend> loadMeetingSend(String id);
	
	public ActionResultInfo<AschemaMeetingSend> saveNewMeetingSend(AschemaMeetingSend entity);
	
	public ActionResultInfo<AschemaMeetingSend> saveNewMeetingSend(AschemaMeetingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateMeetingSend(AschemaMeetingSend entity);
	public ActionResultInfo<String> updateMeetingSend(AschemaMeetingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<AschemaMeetingSend> update(AschemaMeetingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);

	public ActionResultInfo<AschemaMeetingSend> saveNewMeetingSend(AschemaMeetingSend entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser userInfo, String activityId, AssoftFlowRecord flowRecord);
	public ActionResultInfo<String> updateMeetingSend(AschemaMeetingSend entity, Map<String, List<AssoftFileObj>> emap,
			UserProperty userProperty, String activityInstanceId, AschemaMeetingReceive docReceive,
			AssoftFlowRecord flowRecord);
	public ActionResultInfo<String> withdraw(String id, AsopUser user);
	public MeetingReceiveForm loadMeetingForm(String id);
	public ConResponseListInfo<MeetingReceiveForm> listMeetingForms(
			ConditionDomainSchema<AschemaMeetingSend> conditionDomainSchema, PageInfo pageInfo, AsopUser userInfo);
	ActionResultInfo<AschemaMeetingSend> draftSend(AschemaMeetingSend entity,
			Map<String, List<AssoftFileObj>> eleFileMap, AsopUser user,
			String activityId, AssoftFlowRecord flowRecord);
	ActionResultInfo<ConResponseListInfo<AschemaMeetingSend>> listDraft(
			ConditionDomainSchema<AschemaMeetingSend> condition,
			PageInfo pageInfo, UserProperty userProperty);
	ConResponseListInfo<MeetingReceiveForm> listMeetingForms(
			ConditionDomainSchema<AschemaMeetingSend> condition,
			PageInfo pageInfo, AsopUser userInfo, String type);
	ActionResultInfo<String> updateSend(String sendId, String status);
}
