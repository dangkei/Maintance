package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaReceiveReceipt;
import com.soft.web.action.base.ConResponseListInfo;

public interface ReceiveReceiptAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaReceiveReceipt>> listReceiveReceipts(ConditionDomainSchema<AschemaReceiveReceipt> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaReceiveReceipt> listReceiveReceipts(AschemaReceiveReceipt condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaReceiveReceipt loadReceiveReceipt(AschemaReceiveReceipt condition,AsopQueryRequestParam param);
	public int loadNum(AschemaReceiveReceipt condition,AsopQueryRequestParam param);
	public String removeReceiveReceipts(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaReceiveReceipt>> listReceiveReceipts(ConditionDomainSchema<AschemaReceiveReceipt> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeReceiveReceipts(List<String> idList);
	
	public ActionResultInfo<AschemaReceiveReceipt> loadReceiveReceipt(String id);
	
	public ActionResultInfo<AschemaReceiveReceipt> saveNewReceiveReceipt(AschemaReceiveReceipt entity);
	
	public ActionResultInfo<AschemaReceiveReceipt> saveNewReceiveReceipt(AschemaReceiveReceipt entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateReceiveReceipt(AschemaReceiveReceipt entity);
	public ActionResultInfo<String> updateReceiveReceipt(AschemaReceiveReceipt entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
