package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.MeetingReceiveForm;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.soft.web.action.base.ConResponseListInfo;

public interface MeetingReceiveExtendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingReceive>> listMeetingReceives(ConditionDomainSchema<AschemaMeetingReceive> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaMeetingReceive> listMeetingReceives(AschemaMeetingReceive condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaMeetingReceive loadMeetingReceive(AschemaMeetingReceive condition,AsopQueryRequestParam param);
	public int loadNum(AschemaMeetingReceive condition,AsopQueryRequestParam param);
	public String removeMeetingReceives(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingReceive>> listMeetingReceives(ConditionDomainSchema<AschemaMeetingReceive> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeMeetingReceives(List<String> idList);
	
	public ActionResultInfo<AschemaMeetingReceive> loadMeetingReceive(String id);
	
	public ActionResultInfo<AschemaMeetingReceive> saveNewMeetingReceive(AschemaMeetingReceive entity);
	
	public ActionResultInfo<AschemaMeetingReceive> saveNewMeetingReceive(AschemaMeetingReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateMeetingReceive(AschemaMeetingReceive entity);
	public ActionResultInfo<String> updateMeetingReceive(AschemaMeetingReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	public ActionResultInfo<AschemaMeetingReceive> deptReceiveMeeting(AschemaMeetingReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord,
			String activityInstanceId);
	public ActionResultInfo<AschemaMeetingReceive> receiveFileScan(AschemaMeetingReceive entity,
			Map<String, List<AssoftFileObj>> emap, AsopUser user, String activityId, AssoftFlowRecord flowRecord,
			String activityInstanceId);
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingReceive>> listMeetingReceivesForTodo(
			ConditionDomainSchema<AschemaMeetingReceive> conditionDomainSchema, PageInfo pageInfo, AsopUser user);
	public MeetingReceiveForm loadMeetingReceiveForm(String docReceiveId, AsopUser user);
	public ActionResultInfo<String> meetingReceiveBack(String docReceiveId, AsopUser user);
	
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
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingReceive>> listMeetingReceivesForDelete(AschemaMeetingReceive condition, PageInfo pageInfo, AsopUser asopUser);

	public ActionResultInfo<String> restore(String receiveId,AsopUser user);
	ActionResultInfo<ConResponseListInfo<AschemaMeetingReceive>> listMeetingReceivesForTodoByLeader(
			ConditionDomainSchema<AschemaMeetingReceive> condition,
			PageInfo pageInfo, AsopUser user, String loginNames);
}
