package com.assoft.cloud.common.actionextend;

import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.cloud.common.form.ServiceForm;
import com.assoft.cloud.common.form.ServiceTypeForm;
import com.assoft.cloud.common.schema.AschemaService;
import com.assoft.cloud.common.schema.AschemaServicetype;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.domain.db.po.Channel;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.asp.ConditionCata;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

/**
 * 关于应用和服务的扩展类
 * @author wzj
 *
 */
public interface ServiceExtendAction {

	public ConResponseListInfo<ServiceForm> listServiceForms(ConditionDomainSchema<AschemaService> condition,AsopQueryRequestParam param,PageInfo pageInfo);
	public ConResponseListInfo<AschemaService> listServices(ConditionDomainSchema<AschemaService> condition, PageInfo pageInfo,AsopQueryRequestParam param);
	
	public ServiceForm loadServiceForm(String id);
	public Map<String, Integer> buildServiceTodoNumMap(String loginName,List<String> ids);
	public List<AschemaService> listServices(List<String> ids);
	public ActionResultInfo<ConResponseListInfo<AschemaService>> listCanUseServices(String loginName,ConditionDomainSchema<AschemaService> condition, PageInfo pageInfo);
	
	/**
	 * 列出主服务类别
	 * @param conditionCata
	 * @param pageInfo
	 * @return
	 */
	public ConResponseListInfo<ServiceTypeForm> listServiceTypeForms(ConditionCata conditionCata,PageInfo pageInfo);
	

	public ConResponseListInfo<AschemaServicetype> listRootServiceTypes(String title,PageInfo pageInfo);
	

	public ConResponseListInfo<ServiceTypeForm> listOtherServiceTypeForms(ConditionCata conditionCata,PageInfo pageInfo);

    
	/**
	 * 查找服务的跳转地主
	 * @param serviceShortname
	 * @param mobile
	 * @param loginName
	 * @return
	 */
	//public String go2Service(String serviceId,String mobile,String loginName,String skinUrl,HttpServletRequest request);
	
	/**
	 * 发布服务
	 * @param serviceId
	 * @return
	 */
	public ActionResultInfo<String> pubService(String serviceId);
	
	/**
	 * 撤回服务
	 * @param serviceId
	 * @return
	 */
	public ActionResultInfo<String> withdrawService(String serviceId);
	
	
	/**
	 * 服务类别根
	 * @return
	 */
	public Channel loadServicetypeRootCata();
	
	/**
	 * 其他分类根
	 * @return
	 */
	//public AsopCata loadOthertypeRootCata();
	
	/**
	 * 是否需要初始化云平台自带服务
	 * @return
	 */
	public boolean needInitCloudService();
	
	
	
	/**
	 * 初始化云平台自带服务
	 */
	public void initCloudService() throws Exception;
	
	//重新计算服务的授权范围（包括授权部门，用户组，特定用户)
	public void reBuildServiceScope(String serviceId);
	
	public String validBmpUsers(String serviceShortName,List<String> users);
	
	public ActionResultInfo<String> updateServiceOpUsers(String serviceId,List<String> users);
	
	//public ActionResultInfo<ConResponseListInfo<AschemaOthertype>> listOthertypes(ConditionDomainSchema<AschemaOthertype> condition,PageInfo pageInfo);
}
