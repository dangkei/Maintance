package com.assoft.cloud.common.action;

  import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaSyncrecordExport;
import com.soft.web.action.base.ConResponseListInfo;

public interface SyncrecordExportAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaSyncrecordExport>> listSyncrecordExports(ConditionDomainSchema<AschemaSyncrecordExport> condition,PageInfo pageInfo);
	
	public ActionResultInfo<ConResponseListInfo<AschemaSyncrecordExport>> listSyncrecordExports(ConditionDomainSchema<AschemaSyncrecordExport> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeSyncrecordExports(List<String> idList);
	
	public ActionResultInfo<AschemaSyncrecordExport> loadSyncrecordExport(String id);
}
