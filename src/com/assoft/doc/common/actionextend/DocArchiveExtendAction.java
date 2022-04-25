package com.assoft.doc.common.actionextend;

  import java.util.List;
import java.util.Map;









import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.form.DocReceiveForm;
import com.assoft.doc.common.schema.AschemaBriefingReceive;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.assoft.doc.common.schema.AschemaDocReceive;
import com.assoft.doc.common.schema.AschemaDocSend;
import com.assoft.doc.common.schema.AschemaDoneDoc;
import com.assoft.doc.common.schema.AschemaMeetingReceive;
import com.assoft.doc.common.schema.AschemaMeetingSend;
import com.assoft.doc.common.schema.AschemaReceiveReceipt;
import com.assoft.doc.common.schema.AschemaReceiveSign;
import com.soft.web.action.base.ConResponseListInfo;
 
public interface DocArchiveExtendAction {
  
	public void saveBatchDocReceices(List<AschemaDocReceive> list);
	
	public void saveBatchDocSends(List<AschemaDocSend> list);
	
	public void saveBatchMeetingReceices(List<AschemaMeetingReceive> list);
	
	public void saveBatchMeetingSends(List<AschemaMeetingSend> list);
	
	public void saveBatchBriefingReceices(List<AschemaBriefingReceive> list);
	
	public void saveBatchBriefingSends(List<AschemaBriefingSend> list);
	
	public void saveBatchDoneDoc(List<AschemaDoneDoc> list);
	
	public void saveBatchReceiveReceipts(List<AschemaReceiveReceipt> list);
	
	public void saveBatchReceiveSigns(List<AschemaReceiveSign> list);
	
	
}
