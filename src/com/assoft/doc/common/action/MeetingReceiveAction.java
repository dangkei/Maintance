package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.soft.web.action.base.ConResponseListInfo;

public interface MeetingReceiveAction {
  
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
}
