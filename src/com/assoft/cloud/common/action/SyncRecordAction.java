package com.assoft.cloud.common.action;

  import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.cloud.common.schema.AschemaSyncRecord;
import com.soft.web.action.base.ConResponseListInfo;

public interface SyncRecordAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaSyncRecord>> listSyncRecords(ConditionDomainSchema<AschemaSyncRecord> condition,PageInfo pageInfo);
	
	public ActionResultInfo<ConResponseListInfo<AschemaSyncRecord>> listSyncRecords(ConditionDomainSchema<AschemaSyncRecord> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeSyncRecords(List<String> idList);
	
	public ActionResultInfo<AschemaSyncRecord> loadSyncRecord(String id);
}
