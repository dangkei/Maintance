package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.soft.web.action.base.ConResponseListInfo;

public interface DocSendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaDocSend>> listDocSends(ConditionDomainSchema<AschemaDocSend> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaDocSend> listDocSends(AschemaDocSend condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaDocSend loadDocSend(AschemaDocSend condition,AsopQueryRequestParam param);
	public int loadNum(AschemaDocSend condition,AsopQueryRequestParam param);
	public String removeDocSends(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDocSend>> listDocSends(ConditionDomainSchema<AschemaDocSend> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeDocSends(List<String> idList);
	
	public ActionResultInfo<AschemaDocSend> loadDocSend(String id);
	
	public ActionResultInfo<AschemaDocSend> saveNewDocSend(AschemaDocSend entity);
	
	public ActionResultInfo<AschemaDocSend> saveNewDocSend(AschemaDocSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateDocSend(AschemaDocSend entity);
	public ActionResultInfo<String> updateDocSend(AschemaDocSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
