package com.assoft.doc.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.doc.common.schema.AschemaFileView;
import com.soft.web.action.base.ConResponseListInfo;

public interface FileViewAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaFileView>> listFileViews(ConditionDomainSchema<AschemaFileView> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaFileView> listFileViews(AschemaFileView condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaFileView loadFileView(AschemaFileView condition,AsopQueryRequestParam param);
	public int loadNum(AschemaFileView condition,AsopQueryRequestParam param);
	public String removeFileViews(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaFileView>> listFileViews(ConditionDomainSchema<AschemaFileView> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeFileViews(List<String> idList);
	
	public ActionResultInfo<AschemaFileView> loadFileView(String id);
	
	public ActionResultInfo<AschemaFileView> saveNewFileView(AschemaFileView entity);
	
	public ActionResultInfo<AschemaFileView> saveNewFileView(AschemaFileView entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateFileView(AschemaFileView entity);
	public ActionResultInfo<String> updateFileView(AschemaFileView entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
