package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaApprole;
import com.soft.web.action.base.ConResponseListInfo;

public interface ApproleAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaApprole>> listApproles(ConditionDomainSchema<AschemaApprole> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaApprole> listApproles(AschemaApprole condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaApprole loadApprole(AschemaApprole condition,AsopQueryRequestParam param);
	public int loadNum(AschemaApprole condition,AsopQueryRequestParam param);
	public String removeApproles(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaApprole>> listApproles(ConditionDomainSchema<AschemaApprole> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeApproles(List<String> idList);
	
	public ActionResultInfo<AschemaApprole> loadApprole(String id);
	
	public ActionResultInfo<AschemaApprole> saveNewApprole(AschemaApprole entity);
	
	public ActionResultInfo<AschemaApprole> saveNewApprole(AschemaApprole entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateApprole(AschemaApprole entity);
	public ActionResultInfo<String> updateApprole(AschemaApprole entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
