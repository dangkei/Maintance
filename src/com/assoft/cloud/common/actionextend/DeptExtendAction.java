package com.assoft.cloud.common.actionextend;

import java.util.List;

import com.asopdomain.exchange.domain.ActionResultInfo;
import com.assoft.aspweb.common.value.UserProperty;
import com.assoft.cloud.common.form.DeptExchangeInfo;
import com.assoft.cloud.common.form.DeptForm;
import com.assoft.cloud.common.form.DeptFullInfo;
import com.assoft.cloud.common.form.DeptUserInfo;
import com.assoft.cloud.common.form.DeptUsertypeSta;
import com.assoft.cloud.common.form.ServiceForm;
import com.assoft.cloud.common.schema.AschemaDept;
import com.assoft.cloud.common.schema.AschemaService;
import com.assoft.cloud.common.schema.AschemaUser;
import com.assoft.common.search.common.AsopQueryRequestParam;
import com.assoft.file.asopdb.po.PageInfo;
import com.assoft.giss.common.entity.AsopCata;
import com.assoft.giss.common.schema.ConditionDomainSchema;
import com.soft.web.action.base.ConResponseListInfo;

public interface DeptExtendAction {

	
	public List<DeptExchangeInfo> listDeptExchangeInfoList(List<String> deptIds,boolean includeUser);
	
	public DeptExchangeInfo buildDeptExchangeInfo(String deptId,boolean includeUser);
	
	
	public DeptUsertypeSta loadDeptUserSta(String deptId);
	
	
	public DeptFullInfo loadDeptFullInfo(String deptId);
	
	
	public ActionResultInfo<String> importApp(String fid,DeptExchangeInfo info);
	
	public ActionResultInfo<String> importAppList(String fid,List<DeptExchangeInfo> infoList);
	
	
	public ConResponseListInfo<DeptForm> listDeptForms(ConditionDomainSchema<AschemaDept> condition,PageInfo pageInfo,AsopQueryRequestParam param);
	

	public ConResponseListInfo<ServiceForm> listServiceForms(String deptId,ConditionDomainSchema<AschemaService> condition,PageInfo pageInfo);
	
	public ActionResultInfo<String> syncALLDeptAndUser(UserProperty up);
	
	
	
	
	public ConResponseListInfo<DeptForm> listAdminedDepts(String title,String loginName,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaDept> listDeptsByFather(String title,String deptId,PageInfo pageInfo);
	
	public ConResponseListInfo<AschemaUser> listDeptUsers(AschemaUser user,String deptId,boolean includeSon,PageInfo pageInfo);

	public DeptUserInfo loadDeptUserInfo(String userId,String deptId);
	
	public ConResponseListInfo<DeptUserInfo> listDeptUserInfos(AschemaUser user,String deptId,boolean includeSon,PageInfo pageInfo);
	
	public void syncDept(UserProperty up, AsopCata asopCata, String actionType, String schemaShortname);

	public void syncDept(UserProperty up, List<AschemaDept> deptList, String actionType);

	public ConResponseListInfo<AschemaDept> listAllSonDeptForms(ConditionDomainSchema<AschemaDept> condition,
			PageInfo pageInfo, Object object);
}
