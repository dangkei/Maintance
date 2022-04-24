package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.soft.web.action.base.ConResponseListInfo;

public interface MeetingSendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaMeetingSend>> listMeetingSends(ConditionDomainSchema<AschemaMeetingSend> condition,PageInfo pageInfo);
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
}
