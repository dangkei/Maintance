package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;


import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.DocReceiveForm;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.soft.web.action.base.ConResponseListInfo;

public interface DocReceiveExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceives(ConditionDomainSchema<AschemaDocReceive> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaDocReceive> listDocReceives(AschemaDocReceive condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaDocReceive loadDocReceive(AschemaDocReceive condition,AsopQueryRequestParam param);
	public int loadNum(AschemaDocReceive condition,AsopQueryRequestParam param);
	public String removeDocReceives(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceives(ConditionDomainSchema<AschemaDocReceive> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeDocReceives(List<String> idList);
	
	public ActionResultInfo<AschemaDocReceive> loadDocReceive(String id);
	
	public ActionResultInfo<AschemaDocSend> loadDocSend(String id);
	
	public ActionResultInfo<AschemaDocReceive> saveNewDocReceive(AschemaDocReceive entity);
	
	public ActionResultInfo<AschemaDocReceive> saveNewDocReceive(AschemaDocReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateDocReceive(AschemaDocReceive entity);
	public ActionResultInfo<String> updateDocReceive(AschemaDocReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceivesForTodo(ConditionDomainSchema<AschemaDocReceive> conditionDomainSchema, PageInfo pageInfo, AsopUser asopUser);
	public DocReceiveForm loadDocReceiveForm(String docReceiveId, AsopUser user);
	public ActionResultInfo<AschemaDocReceive> deptReceiveDoc(AschemaDocReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord, String activityInstanceId, String opType, String relationIds);
	public ActionResultInfo<AschemaDocReceive> deptReceiveDocAndSendDept(AschemaDocReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord, String activityInstanceId, String opType, String relationIds,List<String> receiveDeptUnit);
	public ActionResultInfo<AschemaDocReceive> receiveFileScan(AschemaDocReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord, String activityInstanceId);
	public ConResponseListInfo<DocReceiveForm> listDocReceiveFormsForTodo(
			ConditionDomainSchema<AschemaDocReceive> conditionDomainSchema, PageInfo pageInfo, AsopUser user);
	public ActionResultInfo<String> docReceiveSign(String docReceiveId, AsopUser user);
	public ActionResultInfo<String> docReceiveBack(String docReceiveId, AsopUser user);
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceiveSigns(String docSendId,
			PageInfo pageInfo, AsopUser user);
	public ActionResultInfo<AschemaDocReceive> govResearchCommentReceive(AschemaDocReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord,
			String activityInstanceId);
	public ConResponseListInfo<AssoftFileObj> loadGovRelationReceive(AsopUser user, String docNo, String docSendId, String docReceiveId, String year);
	
	public ConResponseListInfo<AssoftFileObj> loadGovRelationReceiveFromHistory(AsopUser user, String docNo, String docSendId, String docReceiveId, String year);
	
	public ActionResultInfo<DocReceiveForm> loadGovRelationReceive(AsopUser user, String[] idArrays);
	public long initDoc(AsopUser user);
	/**
	 * 待办已办的删除
	 * @param receiveId
	 * @param removeType
	 * @return
	 */
	public ActionResultInfo<String> remove(String receiveId,String removeType,AsopUser user);
	/**
	 * 彻底删除
	 * @param receiveId
	 * @param user
	 * @return
	 */
	public ActionResultInfo<String> removeThorough(String receiveId,AsopUser user);
	
	/**
	 * 已删列表
	 * @param condition
	 * @param pageInfo
	 * @param asopUser
	 * @return
	 */
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceivesForDelete(AschemaDocReceive condition, PageInfo pageInfo, AsopUser asopUser);

	public ActionResultInfo<String> restore(String receiveId,AsopUser user);
	ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceivesForTodoByLeader(
			ConditionDomainSchema<AschemaDocReceive> condition,
			PageInfo pageInfo, AsopUser asopUser, String loginNames);
}
