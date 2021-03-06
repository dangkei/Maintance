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
import com.assoft.doc.common.schema.AschemaFileView;
import com.assoft.aspweb.service.cache.SchemaDomainCacheManager;
import com.soft.web.action.base.ConResponseListInfo;

import com.assoft.giss.common.exchange.FilerecordServerTool;
@Service
public class FileViewEntityService {

	@Autowired
	AppCataService appCataService;
	
	
	@Autowired
	SchemaDomainService schemaDomainService;
	@Autowired
	LocalService localService;
	
	
	public ConResponseListInfo<AschemaFileView> listFileViews(AschemaFileView condition, PageInfo pageInfo) {
		
		return listFileViews(condition,pageInfo,null);
	}
	
	public ConResponseListInfo<AschemaFileView> listFileViews(AschemaFileView condition, PageInfo pageInfo,AsopQueryRequestParam param) {
		if(condition==null){
			condition=new AschemaFileView();
		}
		ConditionDomainSchema<AschemaFileView> conditionDomainSchema=new ConditionDomainSchema<AschemaFileView>(condition);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(conditionDomainSchema, entityCondition);	
		return listInfo;
	}
	
	
	public ConResponseListInfo<AschemaFileView> listFileViews(AschemaFileView condition, PageInfo pageInfo,AsopQueryRequestParam param,List<String> sortFields) {
		if(condition==null){
			condition=new AschemaFileView();
		}
		ConditionDomainSchema<AschemaFileView> conditionDomainSchema=new ConditionDomainSchema<AschemaFileView>(condition);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		entityCondition.setSortFields(sortFields);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(conditionDomainSchema, entityCondition);	
		return listInfo;
	}
	

	
	public ConResponseListInfo<AschemaFileView> listFileViews(ConditionDomainSchema<AschemaFileView> condition, PageInfo pageInfo) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		return listInfo;
	}
	
	public ConResponseListInfo<AschemaFileView> listFileViews(ConditionDomainSchema<AschemaFileView> condition, PageInfo pageInfo,List<String> sortFields) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.setSortFields(sortFields);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		return listInfo;
	}

    public ConResponseListInfo<AschemaFileView> listFileViews(ConditionDomainSchema<AschemaFileView> condition, PageInfo pageInfo,AsopQueryRequestParam param) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);	
		return listInfo;
	}
	
	 public ConResponseListInfo<AschemaFileView> listFileViews(ConditionDomainSchema<AschemaFileView> condition, PageInfo pageInfo,AsopQueryRequestParam param,List<String> sortFields) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		entityCondition.setSortFields(sortFields);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);	
		return listInfo;
	}
	
	 public ConResponseListInfo<AschemaFileView> listFileViews(ConditionDomainSchema<AschemaFileView> condition, DomainCondition entityCondition) {
	
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);	
		return listInfo;
	}


	public ActionResultInfo<String> removeFileViews(List<String> idList) {
		String appName=appCataService.loadAppName();
		ActionResultInfo<String> resultInfo=null;
		if("1".equals(physicalDeletion())){//????????????
		   resultInfo=cataTool().removeCatas(appName, schemaName(), idList);
		}else{
		   resultInfo=cataTool().removeCatas2Recycle(appName, schemaName(), idList);
		}
		
		if(idList!=null){
			for(String id:idList){
				SchemaDomainCacheManager.getInstance().remove(id, AschemaFileView .class);
			}
		}
		return resultInfo;
	}
	
	public ActionResultInfo<String> removeFileView(String id) {
		List<String> idList=new ArrayList<String>();
		idList.add(id);
		return removeFileViews(idList);
	}
	
	
	
	public AschemaFileView saveNewEntity(AschemaFileView entity)throws Exception{
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
	
	
	public AschemaFileView saveNewEntity(AschemaFileView entity,Map<String, List<AssoftFileObj>> eMap)throws Exception{
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
	
	public String updateEntity(AschemaFileView entity,Map<String, List<AssoftFileObj>> eMap)throws Exception{
		String appName=appCataService.loadAppName();
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		//json??????exTrea
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
	
	
	public String updateEntity(AschemaFileView entity)throws Exception{
		String appName=appCataService.loadAppName();
		List<AsopMetaElement> elements=cataTool().listMetaElementsBySchema(appName, schemaName());
		//json??????exTrea
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
	
	
	public void saveBatchNewContentEntities(List<AschemaFileView> list) {
		if(list!=null&&list.size()>0) {
			String appName=appCataService.loadAppName();
			List<AsopCata> catas=new ArrayList<AsopCata>();
			for(AschemaFileView entity:list) {
				AsopCata cata=buildCataFromEntity(appName,entity);
				catas.add(cata);
			}
			cataTool().saveBatchNewContentCatas(appName, schemaName(), catas);
		}
	}
	
	public void updateBatchEntities(List<AschemaFileView> list) {
		if(list!=null&&list.size()>0) {
			String appName=appCataService.loadAppName();
			List<AsopCata> catas=new ArrayList<AsopCata>();
			for(AschemaFileView entity:list) {
				AsopCata cata=buildCataFromEntity(appName,entity);
				catas.add(cata);
			}
			cataTool().updateCataMainEntities(catas);
		}
	}
	
	
	public AsopCata buildCataFromEntity(String appName,AschemaFileView entity) {
		
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
	
	
	
	
	public AschemaFileView loadEntity(String id){
		AschemaFileView pattern=new AschemaFileView();
		pattern.setId(id);
		return schemaDomainService.loadSchemaDomainById(pattern);
	}
	
	public AschemaFileView loadEntity(ConditionDomainSchema<AschemaFileView> condition){
	
	      return loadEntity(condition,null);
	}
	
	public AschemaFileView loadEntity(AschemaFileView FileView){
	
	     ConditionDomainSchema<AschemaFileView> condition=new ConditionDomainSchema<AschemaFileView>(FileView);
	      return loadEntity(condition,null);
	}
	
	public AschemaFileView loadEntity(AsopQueryRequestParam param){
	     AschemaFileView FileView=new AschemaFileView();

	      return loadEntity(FileView,param);
	}
	
	
	public AschemaFileView loadEntity(AschemaFileView FileView,AsopQueryRequestParam param){
	
	     ConditionDomainSchema<AschemaFileView> condition=new ConditionDomainSchema<AschemaFileView>(FileView);
	      return loadEntity(condition,param);
	}
	
	
	public AschemaFileView loadEntity(ConditionDomainSchema<AschemaFileView> condition,AsopQueryRequestParam param) {
		PageInfo pageInfo=new PageInfo(1);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		List<AschemaFileView> list=listInfo.getContents();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public int loadNum(ConditionDomainSchema<AschemaFileView> condition){
	    return loadNum(condition,null);
	}
	
	public int loadNum(AschemaFileView FileView){
	    ConditionDomainSchema<AschemaFileView> condition=new ConditionDomainSchema<AschemaFileView>(FileView);
	    return loadNum(condition,null);
	}
	public int loadNum(AsopQueryRequestParam param){
	     AschemaFileView FileView=new AschemaFileView();
	    
	    return loadNum(FileView,param);
	}
	
	public int loadNum(AschemaFileView FileView,AsopQueryRequestParam param){
	    ConditionDomainSchema<AschemaFileView> condition=new ConditionDomainSchema<AschemaFileView>(FileView);
	    return loadNum(condition,param);
	}
	
	public int loadNum(ConditionDomainSchema<AschemaFileView> condition,AsopQueryRequestParam param){
		PageInfo pageInfo=new PageInfo(0);
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		entityCondition.addParam(param);
		ConResponseListInfo<AschemaFileView> listInfo=schemaDomainService.listSchemas(condition, entityCondition);
		return listInfo.getPageInfo().getTotalContentNum();
	}
	
   
   //????????????????????????????????????
   public DomainCondition buildDefaultDomainCondition(PageInfo pageInfo) {
		DomainCondition entityCondition=appCataService.buildDomainCondition(pageInfo,sortType(),numberFields());
		return entityCondition;
	}
   
   
   
   public List<String> numberFields(){
		List<String> list=new ArrayList<String>();
		
				return list;
	}
	
	public static String schemaName(){
		return "fileView";
	}
	
	//???????????????1??????????????????  0??????????????????
	public static String sortType(){
		return "1";
	}
	
	
	//???????????????????????????????????? 1?????? 0??????
	public static String physicalDeletion(){
		return "0";
	}
	
	//?????????????????????
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
