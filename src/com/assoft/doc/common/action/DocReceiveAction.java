package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.soft.web.action.base.ConResponseListInfo;

public interface DocReceiveAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceives(ConditionDomainSchema<AschemaDocReceive> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaDocReceive> listDocReceives(AschemaDocReceive condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaDocReceive loadDocReceive(AschemaDocReceive condition,AsopQueryRequestParam param);
	public int loadNum(AschemaDocReceive condition,AsopQueryRequestParam param);
	public String removeDocReceives(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaDocReceive>> listDocReceives(ConditionDomainSchema<AschemaDocReceive> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeDocReceives(List<String> idList);
	
	public ActionResultInfo<AschemaDocReceive> loadDocReceive(String id);
	
	public ActionResultInfo<AschemaDocReceive> saveNewDocReceive(AschemaDocReceive entity);
	
	public ActionResultInfo<AschemaDocReceive> saveNewDocReceive(AschemaDocReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateDocReceive(AschemaDocReceive entity);
	public ActionResultInfo<String> updateDocReceive(AschemaDocReceive entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
