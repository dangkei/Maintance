package com.assoft.chapter.common.action;

  import java.util.List;
import java.util.Map;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.chapter.common.schema.AschemaChapter;
import com.soft.web.action.base.ConResponseListInfo;

public interface ChapterAction {
  
	public ActionResultInfo<ConResponseListInfo<AschemaChapter>> listChapters(ConditionDomainSchema<AschemaChapter> condition,PageInfo pageInfo);
	public ConResponseListInfo<AschemaChapter> listChapters(AschemaChapter condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public AschemaChapter loadChapter(AschemaChapter condition,AsopQueryRequestParam param);
	public int loadNum(AschemaChapter condition,AsopQueryRequestParam param);
	public String removeChapters(String id);
	
	public ActionResultInfo<ConResponseListInfo<AschemaChapter>> listChapters(ConditionDomainSchema<AschemaChapter> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ActionResultInfo<String> removeChapters(List<String> idList);
	
	public ActionResultInfo<AschemaChapter> loadChapter(String id);
	
	public ActionResultInfo<AschemaChapter> saveNewChapter(AschemaChapter entity);
	
	public ActionResultInfo<AschemaChapter> saveNewChapter(AschemaChapter entity,Map<String, List<AssoftFileObj>> eleFileMap);
	
	public ActionResultInfo<String> updateChapter(AschemaChapter entity);
	public ActionResultInfo<String> updateChapter(AschemaChapter entity,Map<String, List<AssoftFileObj>> eleFileMap);
}
