package com.assoft.giss.common.action;

import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.soft.web.action.base.ConResponseListInfo;
/**
 * lucene索引文件中的数据信息。当前支持的形式都为每个领域实体对象的id唯一。
 * @author wzj
 *
 */
public interface LucenedataAction {

	
	
	/**
	 * 删除索引
	 * @param ids
	 * @param rebuild（是否根据存储重建索引）
	 * @return
	 */
	public ActionResultInfo<String> removeLuceneData(List<String> ids,boolean rebuild);
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ActionResultInfo<Map<String, String>> loadLuceneData(String id);
	
	/**
	 * 根据param查询列表
	 * @param param
	 * @param pageInfo
	 * @return
	 */
	public ActionResultInfo<ConResponseListInfo<Map<String, Object>>> listLuceneDatas(String domainName,AsopQueryRequestParam param,PageInfo pageInfo);
	
	
	
}
