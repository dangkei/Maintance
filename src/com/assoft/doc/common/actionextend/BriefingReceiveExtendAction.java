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
import com.assoft.doc.common.form.BriefingReceiveForm;
import com.assoft.doc.common.schema.AschemaBriefingReceive;
import com.soft.web.action.base.ConResponseListInfo;

public interface BriefingReceiveExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingReceive>> listBriefingReceives(ConditionDomainSchema<AschemaBriefingReceive> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaBriefingReceive> listBriefingReceives(AschemaBriefingReceive condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaBriefingReceive loadBriefingReceive(AschemaBriefingReceive condition,AsopQueryRequestParam param);
	public int loadNum(AschemaBriefingReceive condition,AsopQueryRequestParam param);
	public String removeBriefingReceives(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingReceive>> listBriefingReceives(ConditionDomainSchema<AschemaBriefingReceive> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeBriefingReceives(List<String> idList);
	
	public ActionResultInfo<AschemaBriefingReceive> loadBriefingReceive(String id);
	
	public ActionResultInfo<AschemaBriefingReceive> saveNewBriefingReceive(AschemaBriefingReceive entity);
	
	public ActionResultInfo<AschemaBriefingReceive> saveNewBriefingReceive(AschemaBriefingReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateBriefingReceive(AschemaBriefingReceive entity);
	public ActionResultInfo<String> updateBriefingReceive(AschemaBriefingReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<AschemaBriefingReceive> deptReceiveBriefing(AschemaBriefingReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord,
			String activityInstanceId);
	public ActionResultInfo<AschemaBriefingReceive> receiveFileScan(AschemaBriefingReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord,
			String activityInstanceId);
	public BriefingReceiveForm loadBriefingReceiveForm(String docReceiveId, AsopUser user);
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingReceive>> listBriefingReceivesForTodo(
			ConditionDomainSchema<AschemaBriefingReceive> conditionDomainSchema, PageInfo pageInfo, AsopUser user);
	public ActionResultInfo<String> briefingReceiveBack(String docReceiveId, AsopUser user);
	
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
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingReceive>> listBriefingReceivesForDelete(AschemaBriefingReceive condition, PageInfo pageInfo, AsopUser asopUser);

	public ActionResultInfo<String> restore(String receiveId,AsopUser user);
	ActionResultInfo<ConResponseListInfo<AschemaBriefingReceive>> listBriefingReceivesForTodoByLeader(
			ConditionDomainSchema<AschemaBriefingReceive> condition,
			PageInfo pageInfo, AsopUser user, String loginNames);
}
