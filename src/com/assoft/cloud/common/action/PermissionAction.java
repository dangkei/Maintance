package com.assoft.cloud.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaPermission;
import com.soft.web.action.base.ConResponseListInfo;

public interface PermissionAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaPermission>> listPermissions(ConditionDomainSchema<AschemaPermission> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaPermission> listPermissions(AschemaPermission condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaPermission loadPermission(AschemaPermission condition,AsopQueryRequestParam param);
	public int loadNum(AschemaPermission condition,AsopQueryRequestParam param);
	public String removePermissions(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaPermission>> listPermissions(ConditionDomainSchema<AschemaPermission> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removePermissions(List<String> idList);
	
	public ActionResultInfo<AschemaPermission> loadPermission(String id);
	
	public ActionResultInfo<AschemaPermission> saveNewPermission(AschemaPermission entity);
	
	public ActionResultInfo<AschemaPermission> saveNewPermission(AschemaPermission entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updatePermission(AschemaPermission entity);
	public ActionResultInfo<String> updatePermission(AschemaPermission entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
