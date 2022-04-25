package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaReceiveSign;
import com.soft.web.action.base.ConResponseListInfo;

public interface ReceiveSignAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaReceiveSign>> listReceiveSigns(ConditionDomainSchema<AschemaReceiveSign> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaReceiveSign> listReceiveSigns(AschemaReceiveSign condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaReceiveSign loadReceiveSign(AschemaReceiveSign condition,AsopQueryRequestParam param);
	public int loadNum(AschemaReceiveSign condition,AsopQueryRequestParam param);
	public String removeReceiveSigns(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaReceiveSign>> listReceiveSigns(ConditionDomainSchema<AschemaReceiveSign> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeReceiveSigns(List<String> idList);
	
	public ActionResultInfo<AschemaReceiveSign> loadReceiveSign(String id);
	
	public ActionResultInfo<AschemaReceiveSign> saveNewReceiveSign(AschemaReceiveSign entity);
	
	public ActionResultInfo<AschemaReceiveSign> saveNewReceiveSign(AschemaReceiveSign entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateReceiveSign(AschemaReceiveSign entity);
	public ActionResultInfo<String> updateReceiveSign(AschemaReceiveSign entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
