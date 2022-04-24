package com.assoft.giss.service.actionmain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.action.LucenedataAction;
import com.assoft.giss.service.bussiness.LuceneDataService;
import com.soft.web.action.base.ConResponseListInfo;

@Service
public class LucenedataActionImpService implements LucenedataAction {

	@Autowired
	LuceneDataService luceneDataService;

	@Override
	public ActionResultInfo<String> removeLuceneData(List<String> ids,	boolean rebuild) {
		String result=luceneDataService.removeLuceneData(ids, rebuild);
		
		return new ActionResultInfo<String>(result);
	}

	@Override
	public ActionResultInfo<Map<String, String>> loadLuceneData(String id) {
	
		Map<String, String> map=luceneDataService.loadLuceneData(id);
		
		return new ActionResultInfo<Map<String,String>>(map);
	}

	@Override
	public ActionResultInfo<ConResponseListInfo<Map<String, Object>>> listLuceneDatas(String domainName,AsopQueryRequestParam param, PageInfo pageInfo) {
	
		ConResponseListInfo<Map<String, Object>> listInfo=luceneDataService.listLuceneDatas(domainName,param, pageInfo);
		
		return new ActionResultInfo<ConResponseListInfo<Map<String,Object>>>(listInfo);
	}

}
