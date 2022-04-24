package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaCommonOpinion;
import com.soft.web.action.base.ConResponseListInfo;

public interface CommonOpinionAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaCommonOpinion>> listCommonOpinions(ConditionDomainSchema<AschemaCommonOpinion> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaCommonOpinion> listCommonOpinions(AschemaCommonOpinion condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaCommonOpinion loadCommonOpinion(AschemaCommonOpinion condition,AsopQueryRequestParam param);
	public int loadNum(AschemaCommonOpinion condition,AsopQueryRequestParam param);
	public String removeCommonOpinions(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaCommonOpinion>> listCommonOpinions(ConditionDomainSchema<AschemaCommonOpinion> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeCommonOpinions(List<String> idList);
	
	public ActionResultInfo<AschemaCommonOpinion> loadCommonOpinion(String id);
	
	public ActionResultInfo<AschemaCommonOpinion> saveNewCommonOpinion(AschemaCommonOpinion entity);
	
	public ActionResultInfo<AschemaCommonOpinion> saveNewCommonOpinion(AschemaCommonOpinion entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateCommonOpinion(AschemaCommonOpinion entity);
	public ActionResultInfo<String> updateCommonOpinion(AschemaCommonOpinion entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
