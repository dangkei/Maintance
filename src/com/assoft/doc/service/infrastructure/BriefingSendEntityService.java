package com.assoft.doc.service.infrastructure;

 import java.util.List;
 import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.giss.common.value.AssoftExtraMetaElement;
import com.asopdomain.exchange.domain.DomainCondition;
import com.assoft.aspweb.service.bussiness.AppCataService;
import com.assoft.aspweb.service.common.LocalService;
import com.assoft.aspweb.service.bussiness.SchemaDomainService;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.exchange.BodyAppCataTool;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.giss.common.entity.AsopMetaElement;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.giss.common.entity.AsopCata;
import com.assoft.doc.common.schema.AschemaBriefingSend;
import com.assoft.aspweb.service.cache.SchemaDomainCacheManager;
import com.soft.web.action.base.ConResponseListInfo;

import com.assoft.giss.common.exchange.FilerecordServerTool;
@Service
public class BriefingSendEntityService {

	@Autowired
	AppCataService appCataService;
	
	
	@Autowired
	SchemaDomainService schemaDomainService;
	@Autowired
	LocalService localService;
	
	
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(AschemaBriefingSend condition, PageInfo pageInfo) {
		
		return listBriefingSends(condition,pageInfo,null);
	}
	
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(AschemaBriefingSend condition, PageInfo pageInfo,AsopQueryRequestParam param) {
		if(condition==null){
			condition=new AschemaBriefingSend();
		}
		ConditionDomainSchema<AschemaBriefingSend> conditionDomainSchema=new ConditionDomainSchema<AschemaBriefingSend>(condition);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		
		
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(conditionDomainSchema, entityCondition);	
		return listInfo;
	}
	
	
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(AschemaBriefingSend condition, PageInfo pageInfo,AsopQueryRequestParam param,List<String> sortFields) {
		if(condition==null){
			condition=new AschemaBriefingSend();
		}
		ConditionDomainSchema<AschemaBriefingSend> conditionDomainSchema=new ConditionDomainSchema<AschemaBriefingSend>(condition);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		entityCondition.setSortFields(sortFields);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(conditionDomainSchema, entityCondition);	
		return listInfo;
	}
	

	
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition, PageInfo pageInfo) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		return listInfo;
	}
	
	public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition, PageInfo pageInfo,List<String> sortFields) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.setSortFields(sortFields);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		return listInfo;
	}

    public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition, PageInfo pageInfo,AsopQueryRequestParam param) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);	
		return listInfo;
	}
	
	 public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition, PageInfo pageInfo,AsopQueryRequestParam param,List<String> sortFields) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		entityCondition.setSortFields(sortFields);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);	
		return listInfo;
	}
	
	 public ConResponseListInfo<AschemaBriefingSend> listBriefingSends(ConditionDomainSchema<AschemaBriefingSend> condition, DomainCondition entityCondition) {
	
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);	
		return listInfo;
	}


	public ActionResultInfo<String> removeBriefingSends(List<String> idList) {
		String appName=appCataService.loadAppName();
		ActionResultInfo<String> resultInfo=null;
		if("1".equals(physicalDeletion())){//物理删除
		   resultInfo=cataTool().removeCatas(appName, schemaName(), idList);
		}else{
		   resultInfo=cataTool().removeCatas2Recycle(appName, schemaName(), idList);
		}
		
		if(idList!=null){
			for(String id:idList){
				SchemaDomainCacheManager.getInstance().remove(id, AschemaBriefingSend .class);
			}
		}
		return resultInfo;
	}
	
	public ActionResultInfo<String> removeBriefingSend(String id) {
		List<String> idList=new ArrayList<String>();
		idList.add(id);
		return removeBriefingSends(idList);
	}
	
	
	
	public AschemaBriefingSend saveNewEntity(AschemaBriefingSend entity)throws Exception{
		String appName=appCataService.loadAppName();
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		
		List<AssoftExtraMetaElement> extraMetaElements=entity.getExtraMetalements();
		entity.setExtraMetalements(null);
		JSONObject json=(JSONObject)JSONObject.toJSON(entity);
		json.put("extraMetalements", extraMetaElements);
		entity.setExtraMetalements(extraMetaElements);
		
		AsopCata cata=schemaDomainService.buildCataFromBean(elements, json);
		cata.setType(schemaType());
		
        Map<String, List<AssoftFileObj>> fileMap=schemaDomainService.buildSchemaFileMap(elements,json);
		Map<String, List<AssoftFileObj>> eMap=schemaDomainService.buildSchemaEleFileMap(elements,json);
		ActionResultInfo<AsopCata> resultInfo=cataTool().saveNewCata(appName, schemaName(), cata, null, null);
		if(resultInfo.isOk()){
			cata=resultInfo.getResult();
			if(fileMap!=null||eMap!=null){	
				filerecordServerTool().saveNewCataFiles(appName, schemaName(), cata, fileMap,eMap);
			}
			entity.setId(cata.getId());
			entity.setDn(cata.getDn());
			entity.setFatherId(cata.getFatherId());
			entity.setTitle(cata.getTitle());
			entity.setFullMetaName(cata.getFullMetaName());
			return entity;
		}else{
			throw new Exception(resultInfo.getErrorMsg());
		}
	
	}
	
	
	public AschemaBriefingSend saveNewEntity(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eMap)throws Exception{
		String appName=appCataService.loadAppName();
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		
		List<AssoftExtraMetaElement> extraMetaElements=entity.getExtraMetalements();
		entity.setExtraMetalements(null);
		JSONObject json=(JSONObject)JSONObject.toJSON(entity);
		json.put("extraMetalements", extraMetaElements);
		entity.setExtraMetalements(extraMetaElements);
		
		AsopCata cata=schemaDomainService.buildCataFromBean(elements, json);
		cata.setType(schemaType());
		
        Map<String, List<AssoftFileObj>> fileMap=schemaDomainService.buildSchemaFileMap(elements,json);
		//Map<String, List<AssoftFileObj>> eMap=schemaDomainService.buildSchemaEleFileMap(elements,json);
		ActionResultInfo<AsopCata> resultInfo=cataTool().saveNewCata(appName, schemaName(), cata, null, null);
		if(resultInfo.isOk()){
			cata=resultInfo.getResult();
			if(fileMap!=null||eMap!=null){	
				filerecordServerTool().saveNewCataFiles(appName, schemaName(), cata, fileMap,eMap);
			}
			entity.setId(cata.getId());
			entity.setDn(cata.getDn());
			entity.setFatherId(cata.getFatherId());
			entity.setTitle(cata.getTitle());
			entity.setFullMetaName(cata.getFullMetaName());
			return entity;
		}else{
			throw new Exception(resultInfo.getErrorMsg());
		}
	
	}
	
	public String updateEntity(AschemaBriefingSend entity,Map<String, List<AssoftFileObj>> eMap)throws Exception{
		String appName=appCataService.loadAppName();
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		//json转换exTrea
		List<AssoftExtraMetaElement> extraMetaElements=entity.getExtraMetalements();
		entity.setExtraMetalements(null);
		JSONObject json=(JSONObject)JSONObject.toJSON(entity);
		json.put("extraMetalements", extraMetaElements);
		entity.setExtraMetalements(extraMetaElements);
		
		AsopCata cata=schemaDomainService.buildCataFromBean(elements, json);
		cata.setType(schemaType());
        Map<String, List<AssoftFileObj>> fileMap=schemaDomainService.buildSchemaFileMap(elements,json);
		//Map<String, List<AssoftFileObj>> eMap=schemaDomainService.buildSchemaEleFileMap(elements,json);
		ActionResultInfo<AsopCata> resultInfo=cataTool().updateCataMain(appName, schemaName(), cata, null, null);
		SchemaDomainCacheManager.getInstance().remove(entity.getId(), entity.getClass());
		if(resultInfo.isOk()){
			cata=resultInfo.getResult();
			if(fileMap!=null||eMap!=null){	
				filerecordServerTool().updateCataFiles(appName, schemaName(), cata, fileMap,eMap);
			}
			
			return cata.getId();
		}else{
		  throw new Exception(resultInfo.getErrorMsg());
		}

	}
	
	
	public String updateEntity(AschemaBriefingSend entity)throws Exception{
		String appName=appCataService.loadAppName();
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		//json转换exTrea
		List<AssoftExtraMetaElement> extraMetaElements=entity.getExtraMetalements();
		entity.setExtraMetalements(null);
		JSONObject json=(JSONObject)JSONObject.toJSON(entity);
		json.put("extraMetalements", extraMetaElements);
		entity.setExtraMetalements(extraMetaElements);
		
		AsopCata cata=schemaDomainService.buildCataFromBean(elements, json);
		cata.setType(schemaType());
      
		ActionResultInfo<AsopCata> resultInfo=cataTool().updateCataMain(appName, schemaName(), cata, null, null);
		SchemaDomainCacheManager.getInstance().remove(entity.getId(), entity.getClass());
		if(resultInfo.isOk()){
			cata=resultInfo.getResult();
			
			
			return cata.getId();
		}else{
		  throw new Exception(resultInfo.getErrorMsg());
		}

	}
	
	
	public void saveBatchNewContentEntities(List<AschemaBriefingSend> list) {
		if(list!=null&&list.size()>0) {
			String appName=appCataService.loadAppName();
			List<AsopCata> catas=new ArrayList<AsopCata>();
			for(AschemaBriefingSend entity:list) {
				AsopCata cata=buildCataFromEntity(appName,entity);
				catas.add(cata);
			}
			cataTool().saveBatchNewContentCatas(appName, schemaName(), catas);
		}
	}
	
	public void updateBatchEntities(List<AschemaBriefingSend> list) {
		if(list!=null&&list.size()>0) {
			String appName=appCataService.loadAppName();
			List<AsopCata> catas=new ArrayList<AsopCata>();
			for(AschemaBriefingSend entity:list) {
				AsopCata cata=buildCataFromEntity(appName,entity);
				catas.add(cata);
			}
			cataTool().updateCataMainEntities(catas);
		}
	}
	
	
	public AsopCata buildCataFromEntity(String appName,AschemaBriefingSend entity) {
		
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		
		List<AssoftExtraMetaElement> extraMetaElements=entity.getExtraMetalements();
		entity.setExtraMetalements(null);
		JSONObject json=(JSONObject)JSONObject.toJSON(entity);
		json.put("extraMetalements", extraMetaElements);
		entity.setExtraMetalements(extraMetaElements);
		
		AsopCata cata=schemaDomainService.buildCataFromBean(elements, json);
		cata.setType(schemaType());
		return cata;
	}
	
	
	
	
	public AschemaBriefingSend loadEntity(String id){
		AschemaBriefingSend pattern=new AschemaBriefingSend();
		pattern.setId(id);
		return schemaDomainService.loadSchemaDomainById(pattern);
	}
	
	public AschemaBriefingSend loadEntity(ConditionDomainSchema<AschemaBriefingSend> condition){
	
	      return loadEntity(condition,null);
	}
	
	public AschemaBriefingSend loadEntity(AschemaBriefingSend BriefingSend){
	
	     ConditionDomainSchema<AschemaBriefingSend> condition=new ConditionDomainSchema<AschemaBriefingSend>(BriefingSend);
	      return loadEntity(condition,null);
	}
	
	public AschemaBriefingSend loadEntity(AsopQueryRequestParam param){
	     AschemaBriefingSend BriefingSend=new AschemaBriefingSend();

	      return loadEntity(BriefingSend,param);
	}
	
	
	public AschemaBriefingSend loadEntity(AschemaBriefingSend BriefingSend,AsopQueryRequestParam param){
	
	     ConditionDomainSchema<AschemaBriefingSend> condition=new ConditionDomainSchema<AschemaBriefingSend>(BriefingSend);
	      return loadEntity(condition,param);
	}
	
	
	public AschemaBriefingSend loadEntity(ConditionDomainSchema<AschemaBriefingSend> condition,AsopQueryRequestParam param) {
		PageInfo pageInfo=new PageInfo(1);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		List<AschemaBriefingSend> list=listInfo.getContents();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public int loadNum(ConditionDomainSchema<AschemaBriefingSend> condition){
	    return loadNum(condition,null);
	}
	
	public int loadNum(AschemaBriefingSend BriefingSend){
	    ConditionDomainSchema<AschemaBriefingSend> condition=new ConditionDomainSchema<AschemaBriefingSend>(BriefingSend);
	    return loadNum(condition,null);
	}
	public int loadNum(AsopQueryRequestParam param){
	     AschemaBriefingSend BriefingSend=new AschemaBriefingSend();
	    
	    return loadNum(BriefingSend,param);
	}
	
	public int loadNum(AschemaBriefingSend BriefingSend,AsopQueryRequestParam param){
	    ConditionDomainSchema<AschemaBriefingSend> condition=new ConditionDomainSchema<AschemaBriefingSend>(BriefingSend);
	    return loadNum(condition,param);
	}
	
	public int loadNum(ConditionDomainSchema<AschemaBriefingSend> condition,AsopQueryRequestParam param){
		PageInfo pageInfo=new PageInfo(0);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaBriefingSend> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		return listInfo.getPageInfo().getTotalContentNum();
	}
	
   
   //构建默认领域对象查询条件
   public DomainCondition buildDefaultDomainCondition(PageInfo pageInfo) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		return entityCondition;
	}
   
   
   
   public List<String> numberFields(){
		List<String> list=new ArrayList<String>();
		
			     list.add("ele_sendDate");
	    		return list;
	}
	
	public static String schemaName(){
		return "briefingSend";
	}
	
	//排序方式。1按顺序值正序  0按顺序值倒序
	public static String sortType(){
		return "0";
	}
	
	
	//默认删除方式是否物理删除 1为是 0为否
	public static String physicalDeletion(){
		return "0";
	}
	
	//是否为类别方案
	public  String schemaType(){
		return "0";
	}
	
	public BodyAppCataTool cataTool(){
	
		String schemaName=schemaName();
		return appCataService.cataTool(schemaName);
	}
	
	public FilerecordServerTool filerecordServerTool(){
		String schemaName=schemaName();
		return appCataService.cataToolBySchemaName(schemaName,FilerecordServerTool.class);
	}
}
