package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaRole;
import com.soft.web.action.base.ConResponseListInfo;

public interface RoleAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaRole>> listRoles(ConditionDomainSchema<AschemaRole> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaRole> listRoles(AschemaRole condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaRole loadRole(AschemaRole condition,AsopQueryRequestParam param);
	public int loadNum(AschemaRole condition,AsopQueryRequestParam param);
	public String removeRoles(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaRole>> listRoles(ConditionDomainSchema<AschemaRole> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeRoles(List<String> idList);
	
	public ActionResultInfo<AschemaRole> loadRole(String id);
	
	public ActionResultInfo<AschemaRole> saveNewRole(AschemaRole entity);
	
	public ActionResultInfo<AschemaRole> saveNewRole(AschemaRole entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateRole(AschemaRole entity);
	public ActionResultInfo<String> updateRole(AschemaRole entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
