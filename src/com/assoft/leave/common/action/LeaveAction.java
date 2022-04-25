package com.assoft.leave.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.leave.common.schema.AschemaLeave;
import com.soft.web.action.base.ConResponseListInfo;

public interface LeaveAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaLeave>> listLeaves(ConditionDomainSchema<AschemaLeave> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaLeave> listLeaves(AschemaLeave condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaLeave loadLeave(AschemaLeave condition,AsopQueryRequestParam param);
	public int loadNum(AschemaLeave condition,AsopQueryRequestParam param);
	public String removeLeaves(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaLeave>> listLeaves(ConditionDomainSchema<AschemaLeave> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeLeaves(List<String> idList);
	
	public ActionResultInfo<AschemaLeave> loadLeave(String id);
	
	public ActionResultInfo<AschemaLeave> saveNewLeave(AschemaLeave entity);
	
	public ActionResultInfo<AschemaLeave> saveNewLeave(AschemaLeave entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateLeave(AschemaLeave entity);
	public ActionResultInfo<String> updateLeave(AschemaLeave entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
