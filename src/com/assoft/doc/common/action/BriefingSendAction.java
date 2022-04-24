package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.soft.web.action.base.ConResponseListInfo;

public interface BriefingSendAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingSend>> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(AschemaBriefingSend condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaBriefingSend loadBriefingSend(AschemaBriefingSend condition,AsopQueryRequestParam param);
	public int loadNum(AschemaBriefingSend condition,AsopQueryRequestParam param);
	public String removeBriefingSends(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaBriefingSend>> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeBriefingSends(List<String> idList);
	
	public ActionResultInfo<AschemaBriefingSend> loadBriefingSend(String id);
	
	public ActionResultInfo<AschemaBriefingSend> saveNewBriefingSend(AschemaBriefingSend entity);
	
	public ActionResultInfo<AschemaBriefingSend> saveNewBriefingSend(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateBriefingSend(AschemaBriefingSend entity);
	public ActionResultInfo<String> updateBriefingSend(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
