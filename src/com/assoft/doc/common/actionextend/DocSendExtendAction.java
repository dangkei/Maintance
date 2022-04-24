package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.DocReceiveForm;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

public interface DocSendExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaDocSend>> listDocSends(ConditionDomainSchema<AschemaDocSend> condition,PageInfo pageInfo);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDocSend>> listDocSends(ConditionDomainSchema<AschemaDocSend> condition,PageInfo pageInfo, UserProperty userProperty);
	
	public ConResponseListInfo<AschemaDocSend> listDocSends(AschemaDocSend condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaDocSend loadDocSend(AschemaDocSend condition,AsopQueryRequestParam param);
	public int loadNum(AschemaDocSend condition,AsopQueryRequestParam param);
	public String removeDocSends(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDocSend>> listDocSends(ConditionDomainSchema<AschemaDocSend> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeDocSends(List<String> idList);
	
	public ActionResultInfo<AschemaDocSend> loadDocSend(String id);
	
	public ActionResultInfo<AschemaDocSend> saveNewDocSend(AschemaDocSend entity);
	public ActionResultInfo<AschemaDocSend> saveNewDocSend(AschemaDocSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<AschemaDocSend> saveNewDocSend(AschemaDocSend entity,Map<String, List<AssoftFileObj>> eleFileMap, AsopUser asopUser, String activityId, AssoftFlowRecord flowRecord);
	
	public ActionResultInfo<String> updateDocSend(AschemaDocSend entity);
	public ActionResultInfo<AschemaDocSend> updateDocSend(AschemaDocSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<String> updateDocSend(AschemaDocSend entity,Map<String, List<AssoftFileObj>> eleFileMap, UserProperty userProperty, String activityInstanceId);
	
	public ActionResultInfo<String> withdraw(String id, AsopUser user);
	public ActionResultInfo<String> updateDocSend(AschemaDocSend entity, Map<String, List<AssoftFileObj>> emap,
			UserProperty userProperty, String activityInstanceId, AschemaDocReceive docReceive, AssoftFlowRecord flowRecord);
	public DocReceiveForm loadDocForm(String id);
	public ConResponseListInfo<DocReceiveForm> listDocForms(ConditionDomainSchema<AschemaDocSend> conditionDomainSchema,
			PageInfo pageInfo, AsopUser userInfo);

	ActionResultInfo<AschemaDocSend> draftSend(AschemaDocSend entity,
			Map<String, List<AssoftFileObj>> eleFileMap, AsopUser user,
			String activityId, AssoftFlowRecord flowRecord);

	ActionResultInfo<ConResponseListInfo<AschemaDocSend>> listDraft(
			ConditionDomainSchema<AschemaDocSend> condition, PageInfo pageInfo,
			UserProperty userProperty);

	ConResponseListInfo<DocReceiveForm> listDocForms(
			ConditionDomainSchema<AschemaDocSend> condition, PageInfo pageInfo,
			AsopUser userInfo, String type);
	
	
	public ActionResultInfo<String> updateSend(String sendId, String status);
}
