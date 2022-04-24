package com.assoft.car.common.actionextend;

import java.util.List;
import java.util.Map;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.car.common.form.TreeNode;
import com.assoft.car.common.schema.AschemaCar;
import com.assoft.cloudclient.common.AsopUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.flow.common.value.AssoftFlowRecord;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.assoft.giss.common.value.AssoftFileObj;
import com.assoft.todo.common.value.TodoForm;
import com.soft.web.action.base.ConResponseListInfo;


/**
 * 用车申请的扩展类
 * @author wzj
 *
 */
public interface CarExtendAction {

	/**
	 * 根据id加载用车表
	 * @param id
	 * @return
	 */
	public ActionResultInfo<AschemaCar> loadCar(String id);
	
	/**
	 * 加载本单位的人员树
	 * @param condition
	 * @param pageInfo
	 * @param title
	 * @return
	 */
	public ConResponseListInfo<TreeNode> listUsers(AsopUser condition,PageInfo pageInfo, String title);
	/**
	 * 取流程的机构范围树
	 * @param condition
	 * @param pageInfo
	 * @param title
	 * @param activityId
	 * @return
	 */
	public ConResponseListInfo<TreeNode> listUsersForFlow(AsopUser condition,PageInfo pageInfo, String title, String activityId);
	
	/**
	 * 保存用车
	 * @param entity
	 * @param eleFileMap
	 * @return
	 */
	public ActionResultInfo<AschemaCar> saveNewCar(AschemaCar entity,Map<String, List<AssoftFileObj>> eleFileMap);
	/**
	 * 审核用车
	 * @param entity
	 * @param eleFileMap
	 * @param userProperty
	 * @param activityInstanceId
	 * @param flowRecord
	 * @return
	 */
	public ActionResultInfo<String> auditCar(AschemaCar entity,UserProperty userProperty, String activityInstanceId, AssoftFlowRecord flowRecord,List<String> nextUsers);
	
	/**
	 * 结束流程
	 * @param entity
	 * @param userProperty
	 * @param activityInstanceId
	 * @param flowRecord
	 * @return
	 */
	public ActionResultInfo<String> finishCar(AschemaCar entity,UserProperty userProperty, String activityInstanceId, AssoftFlowRecord flowRecord);
	
	/**
	 * 结束流程
	 * @param entity
	 * @param userProperty
	 * @param activityInstanceId
	 * @param flowRecord
	 * @return
	 */
	public ActionResultInfo<String> editDealRes(AschemaCar entity,UserProperty userProperty);
	

	
	
	/**
	 * 更新用车
	 * @param entity
	 * @return
	 */
	public ActionResultInfo<String> updateCar(AschemaCar entity);
	
	
	/**
	 * 更新用车
	 * @param entity
	 * @param eleFileMap
	 * @return
	 */
	public ActionResultInfo<String> updateCar(AschemaCar entity,Map<String, List<AssoftFileObj>> eleFileMap) ;
	
	/**
	 * 根据条件获取用车列表，目前用用车申请列表的获取
	 * @param condition
	 * @param pageInfo
	 * @return
	 */
	public ActionResultInfo<ConResponseListInfo<AschemaCar>> listCars(ConditionDomainSchema<AschemaCar> condition,PageInfo pageInfo);
	/**
	 * 根据条件获取用车列表，目前用用车申请列表的获取
	 * @param condition
	 * @param pageInfo
	 * @return
	 */
	public ActionResultInfo<ConResponseListInfo<AschemaCar>> listCars(ConditionDomainSchema<AschemaCar> condition,PageInfo pageInfo,AsopQueryRequestParam param);

	
	/**
	 * 待办列表
	 * @param loginName
	 * @param pageInfo
	 * @return
	 */
	public ActionResultInfo<ConResponseListInfo<TodoForm>> todoList(String loginName, PageInfo pageInfo,String title);
	
	/**
	 * 撤回操作
	 * @param id
	 * @return
	 */
	public ActionResultInfo<String> withdraw(String id,UserProperty userProperty, String activityInstanceId);
	
	
	/**
	 * 
	 * 发送待办
	 * @param car
	 * @param receivers
	 * @return
	 */
	public ActionResultInfo<String> send2Todo(AschemaCar car,List<String> receivers);
	
	public void saveActivity(AschemaCar entity, AsopUser user, String activityId,List<String> nextUsers);
	
	public void saveActivity(AschemaCar entity, AsopUser user, String activityId,List<String> nextUsers,AssoftFlowRecord flowRecord);
	
	public String loadSystemConfigValueByKey(String key);
	
	public void sendTodoSms(List<String> nextUsers,UserProperty userProperty,String id);
}
