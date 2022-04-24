package com.assoft.giss.service.bussiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asopdomain.exchange.domain.AsopDomain;
import com.asopdomain.exchange.domain.DomainCondition;
import com.asopdomain.exchange.domain.LuceneDomain;
import com.asopdomain.exchange.domain.LuceneDomainCondition;
import com.assoft.asopUtil.common.tool.util.Utils;
import com.assoft.cms6.cms.base.LuceneDomainSearchService;
import com.assoft.cms6.cms.base.LuceneDomainService;
import com.assoft.cms6.cms.base.LuceneDomainToolImpService;
import com.assoft.cms6.cms.base.db.BaseDomainService;
import com.assoft.cms6.cms.base.db.ChannelService;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.domain.db.po.BaseDomain;
import com.assoft.domain.db.po.Channel;
import com.assoft.file.asopdb.po.PageInfo;
import com.soft.web.action.base.ConResponseListInfo;

@Service
public class LuceneDataService {

	@Autowired
	LuceneDomainService luceneDomainService;
	
	@Autowired
	LuceneDomainToolImpService luceneDomainToolImpService;
	@Autowired
	BaseDomainService baseDomainService;
	@Autowired
	LuceneDomainSearchService luceneDomainSearchService;
	
	
	@Autowired
	ChannelService channelService;
	
	public  String removeLuceneData(List<String> ids,	boolean rebuild){
		luceneDomainService.indexSaveService().removeByIds(ids);
		if(rebuild){
			List<AsopDomain> list=new ArrayList<AsopDomain>();
			for(String id:ids){
			   AsopDomain domain=baseDomainService.loadAsopDomain(id);
			   list.add(domain);
			}
			luceneDomainService.saveDomains(list);
		}
		return "1";
	}
	
	
	public Map<String, String> loadLuceneData(String id){
		 
	
		
		AsopQueryRequestParam param=new AsopQueryRequestParam();
		param.setOccur(AsopQueryRequestParam.OCCUR_MUST);
		param.setName("id");
		param.setValue(id);
		PageInfo pageInfo=new PageInfo(1);
		DomainCondition domainCondition=new DomainCondition(pageInfo);
		domainCondition.addParam(param);
		
		List<Map<String, String>> list=luceneDomainSearchService.listContents(domainCondition);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	public ConResponseListInfo<Map<String, Object>> listLuceneDatas(String domainName,AsopQueryRequestParam param, PageInfo pageInfo){
		DomainCondition domainCondition=new DomainCondition(pageInfo);
		List<String> sortFields=new ArrayList<String>();
		sortFields.add("createTime");
		domainCondition.setSortFields(sortFields);
		Class tclass=null;
		if(!Utils.isEmpty(domainName)){
			Class clazz=LuceneDomain.getDomainClass(domainName);
			if(clazz!=null){
				String className=clazz.getName();
				tclass=LuceneDomain.getLuceneDomainClass(className);
			}
			
		}
		
		List<String> ids=luceneDomainSearchService.listContentFields(param, tclass, domainCondition, "id");
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for(String id:ids){
			BaseDomain baseDomain=baseDomainService.loadBaseDomain(id);
			String title=baseDomain.getTitle();
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", id);
			map.put("title", title);
			map.put("createTime", baseDomain.getCreateTime());
			map.put("modifyTime", baseDomain.getModifyTime());
			
			Channel channel=channelService.loadSubject(baseDomain.getChannelId());
			map.put("channel", channel);
			
			list.add(map);
		}
		return new ConResponseListInfo<Map<String,Object>>(list, pageInfo);
	}
	
}
