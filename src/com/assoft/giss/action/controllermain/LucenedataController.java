package com.assoft.giss.action.controllermain;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.asopdomain.exchange.common.Utils;
import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.action.controllermain.AsopBaseController;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.action.LucenedataAction;
import com.assoft.report.util.log.LogRecord;
import com.soft.web.action.base.ConResponseListInfo;

@Controller
@Scope("prototype")
public class LucenedataController extends AsopBaseController<LucenedataAction> {
	private LogRecord logger=LogRecord.getLogRecord(this.getClass());
	
	
	@RequestMapping("/lucenedata/list")
	public String listDatas(String condition,String domainName,PageInfo pageInfo){
		try{
			AsopQueryRequestParam param=null;
			
			if(!Utils.isEmpty(condition)){
				param=JSON.parseObject(condition, AsopQueryRequestParam.class);
			}
		
			ActionResultInfo<ConResponseListInfo<Map<String, Object>>> resultInfo=actionService().listLuceneDatas(domainName,param, pageInfo);
			return go2PageByResult(resultInfo);
			
		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
			return go2Page(buildErrorMap("异常错误"));
		}	
	}
	
	
	
	@RequestMapping("/lucenedata/load")
	public String load(String id){
		try{
			
				ActionResultInfo<Map<String, String>> resultInfo=actionService().loadLuceneData(id);
				return go2PageByResult(resultInfo);
			
	
		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
			return go2Page(buildErrorMap("异常错误"));
		}
	}
	/**
	 * 创建索引
	 * @param ids
	 * @return
	 */
	@RequestMapping("/lucenedata/rebuild")
	public String rebuild(String ids){
		try{
			if(!Utils.isEmpty(ids)){
				String userId=gainSessionUserId();
				List<String> list=JSON.parseObject(ids, List.class);
				ActionResultInfo<String> resultInfo=actionService().removeLuceneData(list, true);
				return go2PageByResult(resultInfo);
			}
			return go2Page("1");
		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
			return go2Page(buildErrorMap("异常错误"));
		}
	}
	
	@RequestMapping("/lucenedata/remove")
	public String remove(String ids){
		try{
			if(!Utils.isEmpty(ids)){
				String userId=gainSessionUserId();
				List<String> list=JSON.parseObject(ids, List.class);
				ActionResultInfo<String> resultInfo=actionService().removeLuceneData(list, false);
				return go2PageByResult(resultInfo);
			}
			return go2Page("1");
		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
			return go2Page(buildErrorMap("异常错误"));
		}
	}
}
